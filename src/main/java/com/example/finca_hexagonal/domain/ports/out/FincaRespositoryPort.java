package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Finca;

import java.util.List;
import java.util.Optional;

public interface FincaRespositoryPort {
    Finca save(Finca finca);

    List<Finca> getAll();

    Optional<Finca> getById(int id);

    Optional<Finca> update(int id, Finca finca);

    boolean deleteById(int id);
}
