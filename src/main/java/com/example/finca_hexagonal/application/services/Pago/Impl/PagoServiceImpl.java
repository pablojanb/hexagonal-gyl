package com.example.finca_hexagonal.application.services.Pago.Impl;

import com.example.finca_hexagonal.application.dto.pago.PagoRequestDTO;
import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;
import com.example.finca_hexagonal.application.mappers.PagoDTOMapper;
import com.example.finca_hexagonal.application.services.ModoDePago.Impl.ModoDePagoUseCaseService;
import com.example.finca_hexagonal.application.services.Pago.PagoService;
import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

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

    @Override
    public PagoResponseDTO save(PagoRequestDTO dto) {
        ModoDePago modoDePago = modoDePagoUseCaseService.getById(dto.getMedioDePagoId())
                .orElseThrow(() -> new EntityNotFoundException("Modo de pago no encontrado con ID: " + dto.getMedioDePagoId()));

        Pago pago = pagoDTOMapper.toModel(dto);
        pago.setModoDePago(modoDePago);

        Pago saved = pagoUseCaseService.save(pago);
        return pagoDTOMapper.toDto(saved);
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
}
