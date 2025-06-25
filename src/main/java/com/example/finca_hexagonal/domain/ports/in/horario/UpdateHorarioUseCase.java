package com.example.finca_hexagonal.domain.ports.in.horario;

import com.example.finca_hexagonal.domain.models.Horario;

import java.util.Optional;

public interface UpdateHorarioUseCase {
    Optional<Horario> updateHorario(int horarioId, Horario horario);
}
