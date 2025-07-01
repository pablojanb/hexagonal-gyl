package com.example.finca_hexagonal.domain.ports.in.permiso;

import com.example.finca_hexagonal.domain.models.Permiso;

import java.util.Optional;

public interface UpdatePermisoUseCase {
    Optional<Permiso> updatePermiso(Long id, Permiso updatePermiso);
}
