package com.example.finca_hexagonal.application.services.Direccion.impl;

import com.example.finca_hexagonal.application.dto.direccion.DireccionDTORequest;
import com.example.finca_hexagonal.application.dto.direccion.DireccionDTOResponse;
import com.example.finca_hexagonal.application.mappers.DireccionDTOMapper;
import com.example.finca_hexagonal.application.services.Direccion.DireccionService;
import com.example.finca_hexagonal.domain.models.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionModelService direccionModelService;
    @Autowired
    private DireccionDTOMapper direccionDTOMapper;

    @Override
    public DireccionDTOResponse createDireccion(DireccionDTORequest direccionDto) {
        Direccion direccion = direccionDTOMapper.toModel(direccionDto);
        Direccion newDireccion = direccionModelService.createDireccion(direccion);
        return direccionDTOMapper.toDto(newDireccion);
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Optional<DireccionDTOResponse> updateDireccionById(Long id, DireccionDTORequest updateDireccionDto) {
        return Optional.empty();
    }

    @Override
    public List<DireccionDTOResponse> getAllDirecciones() {
        return List.of();
    }

    @Override
    public Optional<DireccionDTOResponse> getDireccionById(Long id) {
        return Optional.empty();
    }
}
