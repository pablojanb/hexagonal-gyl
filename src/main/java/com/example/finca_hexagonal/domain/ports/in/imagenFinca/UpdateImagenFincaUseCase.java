package com.example.finca_hexagonal.domain.ports.in.imagenFinca;

import com.example.finca_hexagonal.domain.models.ImagenFinca;

import java.util.Optional;

public interface UpdateImagenFincaUseCase {
    Optional<ImagenFinca> update(Long id, ImagenFinca imagenFinca);
}
