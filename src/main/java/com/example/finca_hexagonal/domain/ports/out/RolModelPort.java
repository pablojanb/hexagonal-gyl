package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface RolModelPort {

    Rol save(Rol rol);

    List<Rol> findAll();

    Rol findById(Long id);

    Rol findByName(String nombre);

    Rol update(Rol rol);

    Boolean deleteById(Long id);

    Rol logicalDeletion(Rol rol);
}
