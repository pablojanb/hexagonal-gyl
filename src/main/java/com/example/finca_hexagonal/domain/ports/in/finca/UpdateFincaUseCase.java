package com.example.finca_hexagonal.domain.ports.in.finca;

import com.example.finca_hexagonal.domain.models.Finca;

import java.util.Optional;

public interface UpdateFincaUseCase {
    Optional<Finca> updateFinca(Long id, Finca finca);
}
