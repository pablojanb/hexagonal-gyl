package com.example.finca_hexagonal.domain.ports.in.detalleFinca;

import com.example.finca_hexagonal.domain.models.DetalleFinca;

import java.util.Optional;

public interface UpdateDetalleFincaUseCase {
    Optional<DetalleFinca> update(Long id, DetalleFinca detalleFinca);
}
