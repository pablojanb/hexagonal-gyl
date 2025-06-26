package com.example.finca_hexagonal.domain.ports.in.imagen_finca;

import com.example.finca_hexagonal.domain.models.ImagenFinca;

import java.util.List;

public interface FindImagenFincaUseCase {
    List<ImagenFinca> getAll();
    ImagenFinca findById(Long id);
}
