package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface RolModelPort {
    Rol save(Rol rol);

    boolean deleteById(Long id);

    Optional<Rol> updateById(Long id, Rol rolUpdate);

    List<Rol> findAll();

    Optional<Rol> findById(Long id);

}
