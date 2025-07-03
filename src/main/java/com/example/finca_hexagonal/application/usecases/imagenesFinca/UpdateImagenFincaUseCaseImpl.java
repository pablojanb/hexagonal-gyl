package com.example.finca_hexagonal.application.usecases.imagenesFinca;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.ports.in.imagenFinca.UpdateImagenFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ImagenFincaModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateImagenFincaUseCaseImpl implements UpdateImagenFincaUseCase {
    private final ImagenFincaModelPort imagenFincaModelPort;

    public UpdateImagenFincaUseCaseImpl(ImagenFincaModelPort imagenFincaModelPort) {
        this.imagenFincaModelPort = imagenFincaModelPort;
    }
    @Override
    public Optional<ImagenFinca> update(Long id, ImagenFinca imagenFinca) {
        return imagenFincaModelPort.updateById(id, imagenFinca);
    }
}
