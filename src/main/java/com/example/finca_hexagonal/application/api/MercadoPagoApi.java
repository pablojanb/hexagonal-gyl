package com.example.finca_hexagonal.application.api;

import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;
import com.example.finca_hexagonal.application.services.Pago.Impl.PagoUseCaseService;
import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.models.enums.EstadoPago;
import com.example.finca_hexagonal.domain.models.enums.EstadoReserva;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoApi {
    @Value("${url.prod}")
    private String urlProduccion;

    private static final String ACCESS_TOKEN = "TEST-1844219062978505-071012-5fad629452f2e442db5198a7495d1980-62228230";

    private final PagoUseCaseService pagoUseCaseService;

    public MercadoPagoApi(PagoUseCaseService pagoUseCaseService) {
        this.pagoUseCaseService = pagoUseCaseService;
    }


    public String generarLinkDePago(PagoResponseDTO dto) throws Exception {
        MercadoPagoConfig.setAccessToken(ACCESS_TOKEN);

        PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                .id(dto.getId().toString())
                .title("Reservar Finca ")
                .description("Reservar Finca por $" + dto.getMontoTotalConImpuestos())
                .quantity(1)
                .currencyId("ARS")
                .unitPrice(dto.getMontoTotalConImpuestos())
                .build();

        List<PreferenceItemRequest> items = new ArrayList<>();
        items.add(itemRequest);

        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                .success(urlProduccion+"/api/pagos/mercadopago")
                .failure(urlProduccion+"/api/pagos/mercadopago")
                .pending(urlProduccion+"/api/pagos/mercadopago")
                .build();


        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
//                .backUrls(backUrls) TODO hay que agregar las url de produccion para redirigir despues de pagar
//                .autoReturn("approved")
                .notificationUrl(urlProduccion+"/api/pagos/notificacion")
                .externalReference(dto.getId().toString())
                .build();
        PreferenceClient client = new PreferenceClient();
        Preference preference = client.create(preferenceRequest);

        return preference.getInitPoint();
    }

    public void paymentProcess(Long paymentId) throws MPException, MPApiException {
        PaymentClient paymentClient = new PaymentClient();

        Payment payment = paymentClient.get(paymentId);

        String estado = payment.getStatus();
        String detalle = payment.getStatusDetail();
        System.out.println(detalle);

        Pago pago = pagoUseCaseService.getPagoById(Long.parseLong(payment.getExternalReference()))
                .orElseThrow(()-> new IllegalArgumentException("Pago no encontrado"));

        pago.getDetalles().add(traducirDetalle(detalle));

        EstadoPago estadoPago = encontrarIdPorEstado(estado);
        pago.setEstadoPago(estadoPago);
        EstadoReserva estadoReserva = cambiarEstadoReserva(estadoPago);

        pago.getReserva().setEstadoReserva(estadoReserva);
        pagoUseCaseService.save(pago);


    }

    private EstadoReserva cambiarEstadoReserva(EstadoPago estadoPago) {
       switch (estadoPago) {
           case PAGADO:
               return EstadoReserva.ACTIVA;
           case PENDIENTE:
               return EstadoReserva.PENDIENTE;
           default:
               return EstadoReserva.CANCELADA;
       }

    }

    private EstadoPago encontrarIdPorEstado(String estado) {
        switch (estado) {
            case "approved":
                return EstadoPago.PAGADO;
            case "in_process":
            case "pending":
                return EstadoPago.PENDIENTE;
            case "rejected":
            case "cancelled":
                return EstadoPago.FALLIDO;
            case "refunded":
            case "charged_back":
                return EstadoPago.REVERTIDO;
            default:
                return EstadoPago.DESCONOCIDO;
        }
    }


    public String traducirDetalle(String detalle) {
        switch (detalle) {
            case "accredited":
                return "Pago acreditado correctamente.";
            case "cc_rejected_insufficient_amount":
                return "Pago rechazado: fondos insuficientes.";
            case "cc_rejected_other_reason":
                return "Pago rechazado por error general";
            case "cc_rejected_bad_filled_security_code":
                return "Número de tarjeta incorrecto.";
            case "cc_rejected_bad_filled_date":
                return "Fecha de expiración inválida.";
            case "cc_rejected_call_for_authorize":
                return "Requiere autorización del banco.";
            case "pending_contingency":
                return "Pago pendiente por problemas técnicos.";
            case "pending_review_manual":
                return "Pago pendiente de revisión manual.";
            case "rejected":
                return "El pago fue rechazado.";
            case "cancelled":
                return "El pago fue cancelado.";
            case "refunded":
                return "El pago fue devuelto.";
            case "charged_back":
                return "El pago fue revertido por el banco.";
            default:
                return "Estado desconocido: " + detalle;
        }
    }
}
