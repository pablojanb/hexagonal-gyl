package com.example.finca_hexagonal.domain.ports.in.finca;

import com.example.finca_hexagonal.domain.models.Finca;

import java.util.List;

public interface GetFincaUseCase {

    List<Finca> getAllFincas();

    Finca getFincaById(int id);
}
