package com.example.finca_hexagonal.domain.ports.in.fechaEspecial;

import com.example.finca_hexagonal.domain.models.FechaEspecial;

import java.util.Optional;

public interface UpdateFechaEspecialUseCase {
    Optional<FechaEspecial> update(Long id, FechaEspecial fechaEspecial);
}
