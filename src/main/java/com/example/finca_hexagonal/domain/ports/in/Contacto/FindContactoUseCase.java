package com.example.finca_hexagonal.domain.ports.in.Contacto;

import domain.models.Contacto;

import java.util.List;
import java.util.Optional;

public interface FindContactoUseCase {
    List<Contacto> getAll();

    Optional<Contacto> getById(int id);

    Optional<Contacto>  getByName(String email);
}
