package com.example.finca_hexagonal.application.services.fechaEspecial.impl;

import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialRequestDTO;
import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialResponseDTO;
import com.example.finca_hexagonal.application.services.FincaService.impl.FincaModelService;
import com.example.finca_hexagonal.application.services.fechaEspecial.FechaEspecialService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FechaEspecialServiceImpl implements FechaEspecialService {


    private FechaEspecialService fechaEspecialService;

    private FincaModelService fincaModelService;

    //privateFechaEspecialDTOMapper

    @Override
    public FechaEspecialResponseDTO create(FechaEspecialRequestDTO fechaEspecialRequestDTO) {
        return null;
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

    @Override
    public FechaEspecialResponseDTO logicalDelete(Long id_fecha) {
        return null;
    }




}
