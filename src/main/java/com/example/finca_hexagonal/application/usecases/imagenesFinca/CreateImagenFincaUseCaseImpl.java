package com.example.finca_hexagonal.application.usecases.imagenesFinca;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.ports.in.imagenFinca.CreateImagenFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ImagenFincaModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateImagenFincaUseCaseImpl implements CreateImagenFincaUseCase {

    private final ImagenFincaModelPort imagenFincaModelPort;

    public CreateImagenFincaUseCaseImpl(ImagenFincaModelPort imagenFincaModelPort) {
        this.imagenFincaModelPort = imagenFincaModelPort;
    }

    @Override
    public ImagenFinca create(ImagenFinca imagenFinca) {
        return imagenFincaModelPort.save(imagenFinca);
    }
}
