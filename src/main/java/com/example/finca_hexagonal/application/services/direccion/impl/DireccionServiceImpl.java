package com.example.finca_hexagonal.application.services.direccion.impl;

import com.example.finca_hexagonal.application.dto.direccion.DireccionDTORequest;
import com.example.finca_hexagonal.application.dto.direccion.DireccionDTOResponse;
import com.example.finca_hexagonal.application.mappers.DireccionDTOMapper;
import com.example.finca_hexagonal.application.services.direccion.DireccionService;

import java.util.List;

public class DireccionServiceImpl implements DireccionService {
    private final DireccionModelService direccionModelService;
    private final DireccionDTOMapper direccionDTOMapper;

    public DireccionServiceImpl(DireccionModelService direccionModelService, DireccionDTOMapper direccionDTOMapper) {
        this.direccionModelService = direccionModelService;
        this.direccionDTOMapper = direccionDTOMapper;
    }

    @Override
    public DireccionDTOResponse create(DireccionDTORequest direccionDto) {
        return null;
    }

    @Override
    public List<DireccionDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public DireccionDTOResponse getById(Long id_direccion) {
        return null;
    }

    @Override
    public DireccionDTOResponse getByAltura(int altura) {
        return null;
    }

    @Override
    public DireccionDTOResponse update(Long id_direccion, DireccionDTORequest direccionDto) {
        return null;
    }

    @Override
    public DireccionDTOResponse delete(Long id_direccion) {
        return null;
    }

    @Override
    public DireccionDTOResponse logicalDelete(Long id_direccion) {
        return null;
    }
}
