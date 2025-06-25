package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Finca;

import java.util.List;
import java.util.Optional;

public interface FincaModelPort {
    Finca save(Finca finca);

    List<Finca> findAll();

    Optional<Finca> findById(int id);

    Optional<Finca> update(int id, Finca finca);

    boolean deleteById(int id);
}
