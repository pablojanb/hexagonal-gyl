package com.example.finca_hexagonal.application.services.DetalleFinca.impl;

import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTORequest;
import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTOResponse;
import com.example.finca_hexagonal.application.mappers.DetalleFincaDTOMapper;
import com.example.finca_hexagonal.application.services.DetalleFinca.DetalleFincaService;
import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFincaServiceImpl implements DetalleFincaService {
    private final DetalleFincaModelService detalleFincaModelService;
    private final DetalleFincaDTOMapper detalleFincaDTOMapper;

    public DetalleFincaServiceImpl(DetalleFincaModelService detalleFincaModelService, DetalleFincaDTOMapper detalleFincaDTOMapper) {
        this.detalleFincaModelService = detalleFincaModelService;
        this.detalleFincaDTOMapper = detalleFincaDTOMapper;
    }

    @Override
    public DetalleFincaDTOResponse save(DetalleFincaDTORequest detalleDto) {
        DetalleFinca detalle = detalleFincaDTOMapper.toModel(detalleDto);
        DetalleFinca newDetalle = detalleFincaModelService.create(detalle);
        return detalleFincaDTOMapper.toDto(newDetalle);
    }

    @Override
    public Optional<DetalleFincaDTOResponse> findById(Long id) {
        DetalleFinca detalle = detalleFincaModelService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Detalle no encontrado: " + id));
        return Optional.of(detalleFincaDTOMapper.toDto(detalle));
    }

    @Override
    public List<DetalleFincaDTOResponse> findAll() {
        List<DetalleFinca> detalles = detalleFincaModelService.getAll();
        return detalleFincaDTOMapper.toDtoList(detalles);
    }

    @Override
    public Optional<DetalleFincaDTOResponse> update(Long id, DetalleFincaDTORequest detalle) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return detalleFincaModelService.delete(id);
    }
}
