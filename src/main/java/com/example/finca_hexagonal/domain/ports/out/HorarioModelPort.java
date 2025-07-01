package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Horario;

import java.util.List;
import java.util.Optional;

public interface HorarioModelPort {
    Horario save(Horario horario);

    boolean deleteById(Long horarioId);

    List<Horario> findAll();

    List<Horario> findAllHorariosByFincaId(Long id);

    List<Horario> findAllHorariosByFincaIdAndDayOfWeek(Long id, String dayOfWeek);

    Optional<Horario> findById(Long horarioId);

    Optional<Horario> update(Long horarioId, Horario horario);
}
