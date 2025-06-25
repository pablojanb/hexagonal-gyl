package com.example.finca_hexagonal.application.usecases.horario;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.ports.in.horario.UpdateHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.HorarioModelPort;

import java.util.Optional;

public class UpdateHorarioUseCaseImpl implements UpdateHorarioUseCase {

    private final HorarioModelPort horarioModelPort;

    public UpdateHorarioUseCaseImpl(HorarioModelPort horarioModelPort) {
        this.horarioModelPort = horarioModelPort;
    }
    @Override
    public Optional<Horario> updateHorario(int horarioId, Horario horario) {
        return horarioModelPort.update(horarioId, horario);
    }
}
