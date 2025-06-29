package com.example.finca_hexagonal.domain.ports.in.permiso;

import com.example.finca_hexagonal.domain.models.Permiso;

import java.util.List;
import java.util.Optional;

public interface FindPermisoUseCase {

    Optional<Permiso> findPermisoById(Long id);
    List<Permiso> getAllPermisos();
}
