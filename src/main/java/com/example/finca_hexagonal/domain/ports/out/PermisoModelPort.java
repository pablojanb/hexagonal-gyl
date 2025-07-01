package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Permiso;

import java.util.List;
import java.util.Optional;

public interface PermisoModelPort {
    Permiso save(Permiso permiso);

    List<Permiso> findAll();

    Optional<Permiso> findById(Long id);

    Optional<Permiso> updateById(Long id, Permiso updatePermiso);

    boolean deleteById(Long id);
}
