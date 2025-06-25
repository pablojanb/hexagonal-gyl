package com.example.finca_hexagonal.application.services.fecha_especial.impl;

//implementa Fecha_EspecialService

import com.example.finca_hexagonal.application.dto.fecha_especal.Fecha_EspecialDTORequest;
import com.example.finca_hexagonal.application.dto.fecha_especal.Fecha_EspecialDTOResponse;
import com.example.finca_hexagonal.application.services.fecha_especial.Fecha_EspecialService;

import java.util.List;

public class Fecha_EspecialServiceImpl implements Fecha_EspecialService {
    private final Fecha_EspecialModelService fecha_EspecialModelService;
    // private final Fecha_EspecialDTOMapper fecha_EspecialDTOMapper;

    public Fecha_EspecialServiceImpl(Fecha_EspecialModelService fechaEspecialModelService/*, Fecha_EspecialDTOMapper fecha_EspecialDTOMapper*/) {
        this.fecha_EspecialModelService = fechaEspecialModelService;
        //this.fecha_EspecialDTOMapper = fecha_EspecialDTOMapper
    }


    @Override
    public Fecha_EspecialDTOResponse create(Fecha_EspecialDTORequest fecha_EspecialDTORequest) {
        return null;
    }

    @Override
    public List<Fecha_EspecialDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Fecha_EspecialDTOResponse getById(Long id_fecha) {
        return null;
    }

    @Override
    public Fecha_EspecialDTOResponse update(Long id_fecha, Fecha_EspecialDTORequest fecha_EspecialDTORequest) {
        return null;
    }

    @Override
    public Fecha_EspecialDTOResponse delete(Long id_fecha) {
        return null;
    }

    @Override
    public Fecha_EspecialDTOResponse logicalDelete(Long id_fecha) {
        return null;
    }
}
