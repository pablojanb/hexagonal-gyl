package com.example.finca_hexagonal.application.usecases.imagenesFinca;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.ports.in.imagenFinca.GetImagenFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ImagenFincaModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetImagenFincaUseCaseImpl implements GetImagenFincaUseCase {

    private final ImagenFincaModelPort imagenFincaModelPort;

    public GetImagenFincaUseCaseImpl(ImagenFincaModelPort imagenFincaModelPort) {
        this.imagenFincaModelPort = imagenFincaModelPort;
    }

    @Override
    public List<ImagenFinca> getAllByFincaId(Long id) {
        return imagenFincaModelPort.findByFinca(id);
    }

    @Override
    public Optional<ImagenFinca> findById(Long id) {
        return imagenFincaModelPort.findById(id);
    }

    @Override
    public List<ImagenFinca> getAllImagenFinca() {
        return imagenFincaModelPort.getAllImagenFinca();
    }
}
