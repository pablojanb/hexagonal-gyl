package com.example.finca_hexagonal.application.usecases.imagenesFinca;

import com.example.finca_hexagonal.domain.ports.in.imagenFinca.DeleteImagenFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ImagenFincaModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteImagenFincaUseCaseImpl implements DeleteImagenFincaUseCase {
    private final ImagenFincaModelPort imagenFincaModelPort;

    public DeleteImagenFincaUseCaseImpl(ImagenFincaModelPort imagenFincaModelPort) {
        this.imagenFincaModelPort = imagenFincaModelPort;
    }

    @Override
    public boolean delete(Long id) {
        return imagenFincaModelPort.delete(id);
    }
}
