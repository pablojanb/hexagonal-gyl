package com.example.finca_hexagonal.domain.ports.in.direccion;

import com.example.finca_hexagonal.domain.models.Direccion;

import java.util.Optional;

public interface UpdateDireccionUseCase {
    Optional<Direccion> updateDireccion(Long id, Direccion updateDireccion);
}
