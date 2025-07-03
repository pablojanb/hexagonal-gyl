package com.example.finca_hexagonal.application.services.imagenFinca.impl;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.ports.in.imagenFinca.CreateImagenFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.imagenFinca.DeleteImagenFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.imagenFinca.GetImagenFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.imagenFinca.UpdateImagenFincaUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenFincaModelService implements CreateImagenFincaUseCase, GetImagenFincaUseCase, UpdateImagenFincaUseCase, DeleteImagenFincaUseCase {

    private final CreateImagenFincaUseCase createImagenFincaUseCase;
    private final GetImagenFincaUseCase getImagenFincaUseCase;
    private final UpdateImagenFincaUseCase updateImagenFincaUseCase;
    private final DeleteImagenFincaUseCase deleteImagenFincaUseCase;

    public ImagenFincaModelService(CreateImagenFincaUseCase createImagenFincaUseCase, GetImagenFincaUseCase getImagenFincaUseCase, UpdateImagenFincaUseCase updateImagenFincaUseCase, DeleteImagenFincaUseCase deleteImagenFincaUseCase) {
        this.createImagenFincaUseCase = createImagenFincaUseCase;
        this.getImagenFincaUseCase = getImagenFincaUseCase;
        this.updateImagenFincaUseCase = updateImagenFincaUseCase;
        this.deleteImagenFincaUseCase = deleteImagenFincaUseCase;
    }

    @Override
    public ImagenFinca create(ImagenFinca imagenFinca) {
        return createImagenFincaUseCase.create(imagenFinca);
    }

    @Override
    public boolean delete(Long id) {
        return deleteImagenFincaUseCase.delete(id);
    }

    @Override
    public List<ImagenFinca> getAllByFincaId(Long id) {
        return getImagenFincaUseCase.getAllByFincaId(id);
    }

    @Override
    public Optional<ImagenFinca> findById(Long id) {
        return getImagenFincaUseCase.findById(id);
    }

    @Override
    public List<ImagenFinca> getAllImagenFinca() {
        return getImagenFincaUseCase.getAllImagenFinca();
    }

    @Override
    public Optional<ImagenFinca> update(Long id, ImagenFinca imagenFinca) {
        return updateImagenFincaUseCase.update(id, imagenFinca);
    }
}
