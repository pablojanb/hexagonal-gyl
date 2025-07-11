package com.example.finca_hexagonal.application.services.fechaEspecial.impl;

import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialRequestDTO;
import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialResponseDTO;
import com.example.finca_hexagonal.application.mappers.FechaEspecialDTOMapper;
import com.example.finca_hexagonal.application.services.finca.impl.FincaModelService;
import com.example.finca_hexagonal.application.services.fechaEspecial.FechaEspecialService;
import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class FechaEspecialServiceImpl implements FechaEspecialService {
    private final FechaEspecialDTOMapper fechaEspecialDTOMapper;
    private final FechaEspecialModelService fechaEspecialModelService;
    private final FincaModelService fincaModelService;

    public FechaEspecialServiceImpl(FechaEspecialDTOMapper fechaEspecialDTOMapper, FechaEspecialModelService fechaEspecialModelService, FincaModelService fincaModelService) {
        this.fechaEspecialDTOMapper = fechaEspecialDTOMapper;
        this.fechaEspecialModelService = fechaEspecialModelService;
        this.fincaModelService = fincaModelService;
    }

    @Override
    public FechaEspecialResponseDTO create(FechaEspecialRequestDTO fechaEspecialRequestDTO) {
        FechaEspecial fechaEspecial = fechaEspecialDTOMapper.toModel(fechaEspecialRequestDTO);
        fechaEspecialModelService.validarFechasExistentes(fechaEspecial);
        FechaEspecial newFechaEspecial = fechaEspecialModelService.create(fechaEspecial);
        return fechaEspecialDTOMapper.toDto(newFechaEspecial);
    }

    @Override
    public List<FechaEspecialResponseDTO> getAll() {
        List<FechaEspecial> fechaEspeciales = fechaEspecialModelService.getAll();
        return fechaEspecialDTOMapper.toDtoList(fechaEspeciales);
    }

    @Override
    public Optional<FechaEspecialResponseDTO> getById(Long idfecha) {
        FechaEspecial fechaEspecial = fechaEspecialModelService.getById(idfecha)
                .orElseThrow(() -> new EntityNotFoundException("Fecha especial no encontrado: " + idfecha));
        return Optional.of(fechaEspecialDTOMapper.toDto(fechaEspecial));
    }

    @Override
    public Optional<FechaEspecialResponseDTO> update(Long idfecha, FechaEspecialRequestDTO fechaEspeciaRequestlDTO) {
        FechaEspecial fechaEspecial = fechaEspecialModelService.getById(idfecha)
                .orElseThrow(() -> new EntityNotFoundException("Fecha especial no encontrada: " + idfecha));
        fechaEspecial.setDiaSemana(fechaEspeciaRequestlDTO.getDiaSemana());
        fechaEspecial.setHoraInicio(fechaEspeciaRequestlDTO.getHoraInicio());
        fechaEspecial.setHoraFin(fechaEspeciaRequestlDTO.getHoraFin());
        fechaEspecial.setRecargo(fechaEspeciaRequestlDTO.getRecargo());
        fechaEspecial.setDescuento(fechaEspeciaRequestlDTO.getDescuento());
        fechaEspecial.setMotivo(fechaEspeciaRequestlDTO.getMotivo());
        fechaEspecial.setFecha(fechaEspeciaRequestlDTO.getFecha());
        Finca finca = fincaModelService.getFincaById(fechaEspeciaRequestlDTO.getFincaId())
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + fechaEspeciaRequestlDTO.getFincaId()));
        fechaEspecial.setFinca(finca);
        fechaEspecialModelService.validarFechasExistentes(fechaEspecial);
        FechaEspecial updatedFechaespecial = fechaEspecialModelService.update(idfecha, fechaEspecial)
                .orElseThrow(() -> new EntityNotFoundException("Fecha especial no encontrada: " + idfecha));
        return Optional.of(fechaEspecialDTOMapper.toDto(updatedFechaespecial));
    }


    @Override
    public boolean delete(Long idfecha) {
        return fechaEspecialModelService.deleteFechaEspecial(idfecha);
    }

    @Override
    public List<FechaEspecialResponseDTO> getAllByFincaId(Long fincaId) {
        List<FechaEspecial> fechasEspeciales = fechaEspecialModelService.getFechasEspByFincaId(fincaId);
        return fechaEspecialDTOMapper.toDtoList(fechasEspeciales);
    }

    @Override
    public Optional<FechaEspecialResponseDTO> getFechaEspecialByFincaIdAndFecha(Long fincaId, LocalDate fecha) {
        FechaEspecial fechaEspecial = fechaEspecialModelService.getFechaEspecialByFincaIdAndFecha(fincaId, fecha)
                .orElseThrow(() -> new EntityNotFoundException("Fecha especial no encontrada: " + fecha));
        return Optional.of(fechaEspecialDTOMapper.toDto(fechaEspecial));
    }
}
