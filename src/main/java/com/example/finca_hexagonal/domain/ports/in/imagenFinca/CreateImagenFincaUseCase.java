package com.example.finca_hexagonal.domain.ports.in.imagenFinca;

import com.example.finca_hexagonal.domain.models.ImagenFinca;

public interface CreateImagenFincaUseCase {
    ImagenFinca create(ImagenFinca imagenFinca);
}
