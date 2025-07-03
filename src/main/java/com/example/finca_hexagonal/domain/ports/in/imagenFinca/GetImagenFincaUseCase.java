package com.example.finca_hexagonal.domain.ports.in.imagenFinca;

import com.example.finca_hexagonal.domain.models.ImagenFinca;

import java.util.List;
import java.util.Optional;

public interface GetImagenFincaUseCase {
    List<ImagenFinca> getAllByFincaId(Long id);
    Optional<ImagenFinca> findById(Long id);
    List<ImagenFinca> getAllImagenFinca();
}
