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

    public String paymentProcess(Long paymentId) throws MPException, MPApiException {
        PaymentClient paymentClient = new PaymentClient();

        Payment payment = paymentClient.get(paymentId);

        String estado = payment.getStatus();

        Pago pago = pagoUseCaseService.getPagoById(Long.parseLong(payment.getExternalReference()))
                .orElseThrow(()-> new IllegalArgumentException("Pago no encontrado"));


        pago.setEstadoPago(encontrarIdPorEstado(estado));
        pago.getReserva().setEstadoReserva(EstadoReserva.ACTIVE);
        pagoUseCaseService.save(pago);
        System.out.println(estado);

        return estado;
    }

    private EstadoPago encontrarIdPorEstado(String estado) {
        if (estado.equals("approved")) {
            return EstadoPago.PAID;
        } else if (estado.equals("in_process")) {
            return EstadoPago.PENDING;
        }
        return null;
    }

}
