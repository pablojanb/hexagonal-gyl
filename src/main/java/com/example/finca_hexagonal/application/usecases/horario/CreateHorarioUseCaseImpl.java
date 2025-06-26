package com.example.finca_hexagonal.application.usecases.horario;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.ports.in.horario.CreateHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.HorarioModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateHorarioUseCaseImpl implements CreateHorarioUseCase {

    private final HorarioModelPort horarioModelPort;

    public CreateHorarioUseCaseImpl(HorarioModelPort horarioModelPort) {
        this.horarioModelPort = horarioModelPort;
    }

    @Override
    public Horario createHorario(Horario horario) {
        return horarioModelPort.save(horario);
    }
}
