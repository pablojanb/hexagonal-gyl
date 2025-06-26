package com.example.finca_hexagonal.application.usecases.horario;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.ports.in.horario.UpdateHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.HorarioModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateHorarioUseCaseImpl implements UpdateHorarioUseCase {

    private final HorarioModelPort horarioModelPort;

    public UpdateHorarioUseCaseImpl(HorarioModelPort horarioModelPort) {
        this.horarioModelPort = horarioModelPort;
    }
    @Override
    public Optional<Horario> updateHorario(Long horarioId, Horario horario) {
        return horarioModelPort.update(horarioId, horario);
    }
}
