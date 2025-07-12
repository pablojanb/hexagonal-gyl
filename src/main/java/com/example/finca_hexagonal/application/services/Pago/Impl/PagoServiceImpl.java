package com.example.finca_hexagonal.application.services.Pago.Impl;

import com.example.finca_hexagonal.application.api.MercadoPagoApi;
import com.example.finca_hexagonal.application.dto.pago.PagoRequestDTO;
import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;
import com.example.finca_hexagonal.application.mappers.PagoDTOMapper;
import com.example.finca_hexagonal.application.services.Pago.PagoService;
import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.models.enums.EstadoPago;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoUseCaseService pagoUseCaseService;
    private final PagoDTOMapper pagoDTOMapper;
    private final MercadoPagoApi mercadoPagoApi;

    public PagoServiceImpl(PagoUseCaseService pagoUseCaseService, PagoDTOMapper pagoDTOMapper, MercadoPagoApi mercadoPagoApi) {
        this.pagoUseCaseService = pagoUseCaseService;
        this.pagoDTOMapper = pagoDTOMapper;
        this.mercadoPagoApi = mercadoPagoApi;
    }

    @Override
    public PagoResponseDTO save(PagoRequestDTO dto) throws Exception {
        Pago pago = pagoDTOMapper.toModel(dto);
        pago.setMonto(pago.getReserva().getTotal());
        pago.setDescuentoAplicado(pago.getReserva().getDescuento());
        pago.setRecargoAplicado(pago.getRecargoAplicado());
        BigDecimal iva = new BigDecimal("1.21");
        pago.setMontoTotal(pago.getReserva().getTotal().multiply(iva));
        Pago saved = pagoUseCaseService.save(pago);
        System.out.println(saved.getMedioPago());
        PagoResponseDTO responseDTO = pagoDTOMapper.toDto(saved);

        System.out.println(pago.getMedioPago());
        System.out.println(dto.getMedioPago());
        System.out.println(responseDTO.getMedioPago());
        String linkPago = crearLinkDePago(responseDTO);
        responseDTO.setLinkPago(linkPago);
        return responseDTO;
    }

    @Override
    public List<PagoResponseDTO> getAllPagos() throws Exception {
        List<Pago> pagos = pagoUseCaseService.getAllPago();
        List<PagoResponseDTO> dtoList = pagoDTOMapper.toDtoList(pagos);
        for (PagoResponseDTO dto : dtoList) {
            if (dto.getEstadoPago().equals(EstadoPago.PENDING)) {
                dto.setLinkPago(crearLinkDePago(dto));

            } else {
                dto.setLinkPago("Pagado");
            }
        }
        return dtoList;
    }

    @Override
    public Optional<PagoResponseDTO> getPagoById(Long id) throws Exception {
        Optional<PagoResponseDTO> pagoResponseDTO = pagoUseCaseService.getPagoById(id)
                .map(pagoDTOMapper::toDto);
        if (pagoResponseDTO.get().getEstadoPago().equals(EstadoPago.PENDING)) {
            pagoResponseDTO.get().setLinkPago(crearLinkDePago(pagoResponseDTO.get()));
        } else {

        pagoResponseDTO.get().setLinkPago("Pagado");
        }
        return pagoResponseDTO;
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

    private String crearLinkDePago(PagoResponseDTO dto) throws Exception {
        switch (dto.getMedioPago().name()) {
            case "MERCADOPAGO":
                return mercadoPagoApi.generarLinkDePago(dto);
            default:
                return "Medio de pago no soportado";
        }
    }
}
