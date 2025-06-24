package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Finca;

import java.util.List;

public interface FincaRespositoryPort {
    Finca save(Finca finca);

    List<Finca> getAll();

    Finca getById(int id);

    Finca update(int id, Finca finca);

    boolean deleteById(int id);
}
