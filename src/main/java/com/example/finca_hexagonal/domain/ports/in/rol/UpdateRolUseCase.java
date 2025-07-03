package com.example.finca_hexagonal.domain.ports.in.rol;

import com.example.finca_hexagonal.domain.models.Rol;

import java.util.Optional;

public interface UpdateRolUseCase {

    Optional<Rol> updateRol(Long id, Rol rolUpdate);
}
