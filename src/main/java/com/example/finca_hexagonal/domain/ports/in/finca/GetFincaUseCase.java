package com.example.finca_hexagonal.domain.ports.in.finca;

import com.example.finca_hexagonal.domain.models.Finca;

import java.util.List;
import java.util.Optional;

public interface GetFincaUseCase {

    List<Finca> getAllFincas();

    Optional<Finca> getFincaById(Long id);
}
