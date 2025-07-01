package com.example.finca_hexagonal.domain.ports.in.Propietario;


import com.example.finca_hexagonal.domain.models.Propietario;

import java.util.List;
import java.util.Optional;

public interface FindPropietarioUseCase {
    List<Propietario> getAll();

    Optional<Propietario> getByid(int id);

    Optional<Propietario> getByName(String nombre);
}
