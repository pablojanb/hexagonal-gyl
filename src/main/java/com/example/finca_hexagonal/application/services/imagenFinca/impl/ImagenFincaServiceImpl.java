package com.example.finca_hexagonal.application.services.imagenFinca.impl;

import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTORequest;
import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTOResponse;
import com.example.finca_hexagonal.application.mappers.ImagenFincaDTOMapper;
import com.example.finca_hexagonal.application.services.imagenFinca.ImagenFincaService;
import com.example.finca_hexagonal.domain.models.ImagenFinca;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenFincaServiceImpl implements ImagenFincaService {

    private final ImagenFincaModelService imagenFincaModelService;
    private final ImagenFincaDTOMapper imagenFincaDTOMapper;

    public ImagenFincaServiceImpl(ImagenFincaModelService imagenFincaModelService, ImagenFincaDTOMapper imagenFincaDTOMapper) {
        this.imagenFincaModelService = imagenFincaModelService;
        this.imagenFincaDTOMapper = imagenFincaDTOMapper;
    }

    @Override
    public ImagenFincaDTOResponse createImagen(ImagenFincaDTORequest imagen) {
        ImagenFinca imagenFinca = imagenFincaDTOMapper.toModel(imagen);
        ImagenFinca newImagenFinca = imagenFincaModelService.create(imagenFinca);
        return imagenFincaDTOMapper.toDto(newImagenFinca);
    }

    @Override
    public Optional<ImagenFincaDTOResponse> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ImagenFincaDTOResponse> updateById(Long id, ImagenFincaDTORequest imagenFincaUpdate) {
        return Optional.empty();
    }

    @Override
    public List<ImagenFincaDTOResponse> getByFincaId(Long fincaId) {
        return List.of();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
