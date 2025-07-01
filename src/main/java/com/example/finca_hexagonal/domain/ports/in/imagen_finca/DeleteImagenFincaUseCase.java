package com.example.finca_hexagonal.domain.ports.in.imagen_finca;

import com.example.finca_hexagonal.domain.models.ImagenFinca;

public interface DeleteImagenFincaUseCase {
    boolean delete(Long id);
    ImagenFinca logicalDeletion(ImagenFinca imagenFinca);
}
