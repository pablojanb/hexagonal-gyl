package com.example.finca_hexagonal.application.usecases.horario;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.ports.in.horario.GetHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.HorarioModelPort;

import java.util.List;
import java.util.Optional;

public class GetHorarioUseCaseImpl implements GetHorarioUseCase {
    private final HorarioModelPort horarioModelPort;

    public GetHorarioUseCaseImpl(HorarioModelPort horarioModelPort) {
        this.horarioModelPort = horarioModelPort;
    }
    @Override
    public List<Horario> getAllHorarios() {
        return horarioModelPort.findAll();
    }

    @Override
    public Optional<Horario> getHorarioById(int horarioId) {
        return horarioModelPort.findById(horarioId);
    }
}
