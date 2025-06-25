package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Horario;

import java.util.List;
import java.util.Optional;

public interface HorarioModelPort {
    Horario save(Horario horario);

    boolean deleteById(int horarioId);

    List<Horario> findAll();

    Optional<Horario> findById(int horarioId);

    Optional<Horario> update(int horarioId, Horario horario);
}
