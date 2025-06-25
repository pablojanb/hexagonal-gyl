package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Finca;

import java.util.List;
import java.util.Optional;

public interface FincaModelPort {
    Finca save(Finca finca);

    List<Finca> findAll();

    Optional<Finca> findById(Long id);

    Optional<Finca> update(Long id, Finca finca);

    boolean deleteById(Long id);
}
