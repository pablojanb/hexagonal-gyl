package com.example.finca_hexagonal.domain.ports.in.horario;

import com.example.finca_hexagonal.domain.models.Horario;

import java.util.List;
import java.util.Optional;

public interface GetHorarioUseCase {

    List<Horario> getAllHorarios();

    List<Horario> getAllHorariosByFincaId(Long id);

    List<Horario> getAllHorariosByFincaIdAndDayOfWeek(Long id, String dayOfWeek);

    Optional<Horario> getHorarioById(Long horarioId);
}
