package com.example.finca_hexagonal.domain.ports.out;
import com.example.finca_hexagonal.domain.models.ImagenFinca;

import java.util.List;
import java.util.Optional;

public interface ImagenFincaRepository {
    ImagenFinca guardar(ImagenFinca imagen);
    Optional<ImagenFinca> buscarPorId(Long id);
    List<ImagenFinca> buscarPorFinca(Long fincaId);
    void eliminar(Long id);
}
