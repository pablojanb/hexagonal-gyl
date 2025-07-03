package com.example.finca_hexagonal.application.services.imagenFinca.impl;

import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTORequest;
import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTOResponse;
import com.example.finca_hexagonal.application.mappers.ImagenFincaDTOMapper;
import com.example.finca_hexagonal.application.services.finca.impl.FincaModelService;
import com.example.finca_hexagonal.application.services.imagenFinca.ImagenFincaService;
import com.example.finca_hexagonal.domain.models.*;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenFincaServiceImpl implements ImagenFincaService {

    private final ImagenFincaModelService imagenFincaModelService;
    private final ImagenFincaDTOMapper imagenFincaDTOMapper;
    private final FincaModelService fincaModelService;

    public ImagenFincaServiceImpl(ImagenFincaModelService imagenFincaModelService, ImagenFincaDTOMapper imagenFincaDTOMapper, FincaModelService fincaModelService) {
        this.imagenFincaModelService = imagenFincaModelService;
        this.imagenFincaDTOMapper = imagenFincaDTOMapper;
        this.fincaModelService = fincaModelService;
    }

    @Override
    public ImagenFincaDTOResponse createImagen(ImagenFincaDTORequest imagen) {
        ImagenFinca imagenFinca = imagenFincaDTOMapper.toModel(imagen);
        ImagenFinca newImagenFinca = imagenFincaModelService.create(imagenFinca);
        return imagenFincaDTOMapper.toDto(newImagenFinca);
    }

    @Override
    public Optional<ImagenFincaDTOResponse> getById(Long id) {
        ImagenFinca imagen = imagenFincaModelService.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Imagen no encontrada: " + id));
        return Optional.of(imagenFincaDTOMapper.toDto(imagen));
    }

    @Override
    public Optional<ImagenFincaDTOResponse> updateById(Long id, ImagenFincaDTORequest imagenDto) {
        ImagenFinca imagenFinca = imagenFincaModelService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Imagen no encontrada: " + imagenDto));
        imagenFinca.setEsPortada(imagenDto.isEsPortada());
        imagenFinca.setUrl(imagenDto.getUrl());
        Finca finca = fincaModelService.getFincaById(imagenDto.getFincaId())
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + imagenDto.getFincaId()));
        imagenFinca.setFinca(finca);
        ImagenFinca updatedFinca = imagenFincaModelService.update(id, imagenFinca)
                .orElseThrow(() -> new EntityNotFoundException("Imagen no encontrada: " + imagenDto));
        return Optional.of(imagenFincaDTOMapper.toDto(updatedFinca));
    }

    @Override
    public List<ImagenFincaDTOResponse> getAllImagenFinca() {
        List<ImagenFinca> imagenFinca = imagenFincaModelService.getAllImagenFinca();
        return imagenFincaDTOMapper.toDtoList(imagenFinca);
    }

    @Override
    public boolean deleteById(Long id) {
        return imagenFincaModelService.delete(id);
    }
}
