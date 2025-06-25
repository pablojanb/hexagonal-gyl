package com.example.finca_hexagonal.application.usecases.horario;

import com.example.finca_hexagonal.domain.ports.in.horario.DeleteHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.HorarioModelPort;

public class DeleteHorarioUseCaseImpl implements DeleteHorarioUseCase {

    private final HorarioModelPort horarioModelPort;

    public DeleteHorarioUseCaseImpl(HorarioModelPort horarioModelPort) {
        this.horarioModelPort = horarioModelPort;
    }
    @Override
    public boolean deleteHorario(int horarioId) {
        return horarioModelPort.deleteById(horarioId);
    }
}
