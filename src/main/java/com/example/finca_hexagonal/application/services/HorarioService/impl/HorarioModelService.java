package com.example.finca_hexagonal.application.services.HorarioService.impl;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.ports.in.horario.CreateHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.horario.DeleteHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.horario.GetHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.horario.UpdateHorarioUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioModelService implements CreateHorarioUseCase, DeleteHorarioUseCase, UpdateHorarioUseCase, GetHorarioUseCase {

    private final CreateHorarioUseCase createHorarioUseCase;
    private final DeleteHorarioUseCase deleteHorarioUseCase;
    private final UpdateHorarioUseCase updateHorarioUseCase;
    private final GetHorarioUseCase getHorarioUseCase;

    public HorarioModelService(CreateHorarioUseCase createHorarioUseCase, DeleteHorarioUseCase deleteHorarioUseCase, UpdateHorarioUseCase updateHorarioUseCase, GetHorarioUseCase getHorarioUseCase) {
        this.createHorarioUseCase = createHorarioUseCase;
        this.deleteHorarioUseCase = deleteHorarioUseCase;
        this.updateHorarioUseCase = updateHorarioUseCase;
        this.getHorarioUseCase = getHorarioUseCase;
    }


    @Override
    public Horario createHorario(Horario horario) {
        return createHorarioUseCase.createHorario(horario);
    }

    @Override
    public boolean deleteHorario(Long horarioId) {
        return deleteHorarioUseCase.deleteHorario(horarioId);
    }

    @Override
    public List<Horario> getAllHorarios() {
        return getHorarioUseCase.getAllHorarios();
    }

    @Override
    public List<Horario> getAllHorariosByFincaId(Long id) {
        return getHorarioUseCase.getAllHorariosByFincaId(id);
    }

    @Override
    public List<Horario> getAllHorariosByFincaIdAndDayOfWeek(Long id, String dayOfWeek) {
        return getHorarioUseCase.getAllHorariosByFincaIdAndDayOfWeek(id, dayOfWeek);
    }

    @Override
    public Optional<Horario> getHorarioById(Long horarioId) {
        return getHorarioUseCase.getHorarioById(horarioId);
    }

    @Override
    public Optional<Horario> updateHorario(Long horarioId, Horario horario) {
        return updateHorarioUseCase.updateHorario(horarioId, horario);
    }
}
