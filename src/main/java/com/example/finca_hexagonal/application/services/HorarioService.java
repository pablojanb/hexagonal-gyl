package com.example.finca_hexagonal.application.services;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.ports.in.horario.CreateHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.horario.DeleteHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.horario.GetHorarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.horario.UpdateHorarioUseCase;

import java.util.List;
import java.util.Optional;

public class HorarioService implements CreateHorarioUseCase, DeleteHorarioUseCase, UpdateHorarioUseCase, GetHorarioUseCase {

    private final CreateHorarioUseCase createHorarioUseCase;
    private final DeleteHorarioUseCase deleteHorarioUseCase;
    private final UpdateHorarioUseCase updateHorarioUseCase;
    private final GetHorarioUseCase getHorarioUseCase;

    public HorarioService(CreateHorarioUseCase createHorarioUseCase, DeleteHorarioUseCase deleteHorarioUseCase, UpdateHorarioUseCase updateHorarioUseCase, GetHorarioUseCase getHorarioUseCase) {
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
    public boolean deleteHorario(int horarioId) {
        return deleteHorarioUseCase.deleteHorario(horarioId);
    }

    @Override
    public List<Horario> getAllHorarios() {
        return getHorarioUseCase.getAllHorarios();
    }

    @Override
    public Optional<Horario> getHorarioById(int horarioId) {
        return getHorarioUseCase.getHorarioById(horarioId);
    }

    @Override
    public Optional<Horario> updateHorario(int horarioId, Horario horario) {
        return updateHorarioUseCase.updateHorario(horarioId, horario);
    }
}
