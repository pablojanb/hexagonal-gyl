package com.example.finca_hexagonal.domain.ports.out;
import com.example.finca_hexagonal.domain.models.ImagenFinca;

import java.util.List;
import java.util.Optional;

public interface ImagenFincaModelPort {

    ImagenFinca save(ImagenFinca imagen);

    Optional<ImagenFinca> findById(Long id);

    Optional<ImagenFinca> updateById(Long id, ImagenFinca imagenFincaUpdate);

    List<ImagenFinca> findByFinca(Long fincaId);

    List<ImagenFinca> getAllImagenFinca();

    boolean delete(Long id);
}
