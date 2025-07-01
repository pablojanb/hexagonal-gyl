package com.example.finca_hexagonal.domain.ports.in.rol;

import com.example.finca_hexagonal.domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface FindRolUseCase {
    List<Rol> getAll();

    Rol getById(Long id);
    Rol getByName(String nombre);
}
