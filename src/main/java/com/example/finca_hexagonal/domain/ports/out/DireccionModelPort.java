package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Direccion;

import java.util.List;
import java.util.Optional;

public interface DireccionModelPort {
    Direccion saveDireccion(Direccion direccion);

    boolean deleteById(Long id);

    Optional<Direccion> updateById(Long id, Direccion updateDireccion);

    List<Direccion> findAll();

    Optional<Direccion> findById(Long id);
}
