package com.example.finca_hexagonal.domain.ports.out;
import com.example.finca_hexagonal.domain.models.ImagenFinca;

import java.util.List;
import java.util.Optional;

public interface ImagenFincaModelPort {

    ImagenFinca save(ImagenFinca imagen);

    Optional<ImagenFinca> findById(Long id);

    List<ImagenFinca> findByFinca(Long fincaId);
    void delete(Long id);
}
