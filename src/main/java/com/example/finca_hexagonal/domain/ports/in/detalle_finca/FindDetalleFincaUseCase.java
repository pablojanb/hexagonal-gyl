package com.example.finca_hexagonal.domain.ports.in.detalle_finca;

import com.example.finca_hexagonal.domain.models.DetalleFinca;

import java.util.List;
import java.util.Optional;

public interface FindDetalleFincaUseCase {
    List<DetalleFinca> getAll();

    Optional<DetalleFinca> getById(Long Id);
}
