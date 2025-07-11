package com.example.finca_hexagonal.application.services.Pago.Impl;

import com.example.finca_hexagonal.application.dto.pago.PagoRequestDTO;
import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;
import com.example.finca_hexagonal.application.mappers.PagoDTOMapper;
import com.example.finca_hexagonal.application.services.ModoDePago.Impl.ModoDePagoUseCaseService;
import com.example.finca_hexagonal.application.services.Pago.PagoService;
import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.models.enums.EstadoPago;
import com.example.finca_hexagonal.domain.models.enums.EstadoReserva;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.MercadoPagoClient;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.resources.preference.PreferenceBackUrls;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {
    @Value("${url.prod}")
    private String urlProduccion;

    private static final String ACCESS_TOKEN = "TEST-1844219062978505-071012-5fad629452f2e442db5198a7495d1980-62228230";

    private final PagoUseCaseService pagoUseCaseService;
    private final ModoDePagoUseCaseService modoDePagoUseCaseService;
    private final PagoDTOMapper pagoDTOMapper;

    public PagoServiceImpl(
            PagoUseCaseService pagoUseCaseService,
            ModoDePagoUseCaseService modoDePagoUseCaseService,
            PagoDTOMapper pagoDTOMapper
    ) {
        this.pagoUseCaseService = pagoUseCaseService;
        this.modoDePagoUseCaseService = modoDePagoUseCaseService;
        this.pagoDTOMapper = pagoDTOMapper;
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

    @Override
    public PagoResponseDTO save(PagoRequestDTO dto) throws Exception {
        ModoDePago modoDePago = modoDePagoUseCaseService.getById(dto.getMedioDePagoId())
                .orElseThrow(() -> new EntityNotFoundException("Modo de pago no encontrado con ID: " + dto.getMedioDePagoId()));

        Pago pago = pagoDTOMapper.toModel(dto);
        pago.setModoDePago(modoDePago);
        pago.setMonto(pago.getReserva().getTotal());
        BigDecimal iva = new BigDecimal("1.21");
        pago.setMontoTotal(pago.getReserva().getTotal().multiply(iva));
        Pago saved = pagoUseCaseService.save(pago);

        PagoResponseDTO responseDTO = pagoDTOMapper.toDto(saved);
        responseDTO.setLinkPago(generarLinkDePago(responseDTO));
        return responseDTO;
    }

    @Override
    public List<PagoResponseDTO> getAllPagos() {
        List<Pago> pagos = pagoUseCaseService.getAllPago();
        return pagoDTOMapper.toDtoList(pagos);
    }

    @Override
    public Optional<PagoResponseDTO> getPagoById(Long id) {
        return pagoUseCaseService.getPagoById(id)
                .map(pagoDTOMapper::toDto);
    }

    @Override
    public Optional<PagoResponseDTO> updatePago(Long id, PagoRequestDTO dto) {
        Pago pago = pagoDTOMapper.toModel(dto);
        return pagoUseCaseService.updatePago(id, pago)
                .map(pagoDTOMapper::toDto);
    }

    @Override
    public boolean deletePago(Long id) {
        return pagoUseCaseService.deletePago(id);
    }

    @Override
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
