package com.example.finca_hexagonal.application.services.imagenFinca.impl;

import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTORequest;
import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTOResponse;
import com.example.finca_hexagonal.application.mappers.ImagenFincaDTOMapper;
import com.example.finca_hexagonal.application.services.imagenFinca.ImagenFincaService;
import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
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
        ImagenFinca imagen = imagenFincaModelService.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Imagen no encontrada: " + id));
        return Optional.of(imagenFincaDTOMapper.toDto(imagen));
    }

    @Override
    public Optional<ImagenFincaDTOResponse> updateById(Long id, ImagenFincaDTORequest imagenDto) {
        ImagenFinca imagenFinca = imagenFincaDTOMapper.toModel(imagenDto);
        return imagenFincaModelService.update(id, imagenFinca)
                .map(imagenFincaDTOMapper::toDto);
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
