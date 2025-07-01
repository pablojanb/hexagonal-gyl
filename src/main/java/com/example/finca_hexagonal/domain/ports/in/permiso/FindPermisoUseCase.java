package com.example.finca_hexagonal.domain.ports.in.permiso;

import com.example.finca_hexagonal.domain.models.Permiso;

import java.util.List;
import java.util.Optional;

public interface FindPermisoUseCase {

    Permiso findPermisoById(Long id);
    List<Permiso> getAllPermisos();
}
