package com.example.finca_hexagonal.domain.ports.in.horario;

import com.example.finca_hexagonal.domain.models.Horario;

public interface CreateHorarioUseCase {
    Horario createHorario(Horario horario);
}
