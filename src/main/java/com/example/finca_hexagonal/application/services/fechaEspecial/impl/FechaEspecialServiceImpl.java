package com.example.finca_hexagonal.application.services.fechaEspecial.impl;

import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialRequestDTO;
import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialResponseDTO;
import com.example.finca_hexagonal.application.mappers.FechaEspecialDTOMapper;
import com.example.finca_hexagonal.application.services.finca.impl.FincaModelService;
import com.example.finca_hexagonal.application.services.fechaEspecial.FechaEspecialService;
import com.example.finca_hexagonal.domain.models.FechaEspecial;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FechaEspecialServiceImpl implements FechaEspecialService {
    private final FechaEspecialDTOMapper fechaEspecialDTOMapper;
    private final FechaEspecialModelService fechaEspecialModelService;

    public FechaEspecialServiceImpl(FechaEspecialDTOMapper fechaEspecialDTOMapper, FechaEspecialModelService fechaEspecialModelService) {
        this.fechaEspecialDTOMapper = fechaEspecialDTOMapper;
        this.fechaEspecialModelService = fechaEspecialModelService;
    }

    @Override
    public FechaEspecialResponseDTO create(FechaEspecialRequestDTO fechaEspecialRequestDTO) {
        FechaEspecial fechaEspecial = fechaEspecialDTOMapper.toModel(fechaEspecialRequestDTO);
        FechaEspecial newFechaEspecial = fechaEspecialModelService.create(fechaEspecial);
        return fechaEspecialDTOMapper.toDto(newFechaEspecial);
    }

    @Override
    public List<FechaEspecialResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public FechaEspecialResponseDTO getById(Long idfecha) {
        return null;
    }

    @Override
    public FechaEspecialResponseDTO update(Long idfecha, FechaEspecialRequestDTO fechaEspeciaRequestlDTO) {
        return null;
    }

    @Override
    public boolean delete(Long idfecha){
        return false;
    }
}
