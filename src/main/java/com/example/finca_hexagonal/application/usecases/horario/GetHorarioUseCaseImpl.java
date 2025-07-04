package com.example.finca_hexagonal.application.usecases.horario;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.ports.in.horario.GetHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.HorarioModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public List<Horario> getAllHorariosByFincaId(Long id) {
        return horarioModelPort.findAllHorariosByFincaId(id);
    }

    @Override
    public List<Horario> getAllHorariosByFincaIdAndDayOfWeek(Long id, String dayOfWeek) {
        return horarioModelPort.findAllHorariosByFincaIdAndDayOfWeek(id, dayOfWeek);
    }

    @Override
    public Optional<Horario> getHorarioById(Long horarioId) {
        return horarioModelPort.findById(horarioId);
    }
}
