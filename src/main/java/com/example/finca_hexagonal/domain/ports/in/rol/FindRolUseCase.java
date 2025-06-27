package com.example.finca_hexagonal.domain.ports.in.rol;

import com.example.finca_hexagonal.domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface FindRolUseCase {
    List<Rol> getAll();

    Optional<Rol> getById(Long id);
    Optional<Rol> getByName(String nombre);
}
