package com.example.finca_hexagonal.application.services;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.ports.in.finca.CreateFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.finca.DeleteFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.finca.GetFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.finca.UpdateFincaUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincaService implements CreateFincaUseCase, DeleteFincaUseCase, UpdateFincaUseCase, GetFincaUseCase {

    private final CreateFincaUseCase createFincaUseCase;
    private final DeleteFincaUseCase deleteFincaUseCase;
    private final GetFincaUseCase getFincaUseCase;
    private final UpdateFincaUseCase updateFincaUseCase;

    public FincaService(CreateFincaUseCase createFincaUseCase, DeleteFincaUseCase deleteFincaUseCase, GetFincaUseCase getFincaUseCase, UpdateFincaUseCase updateFincaUseCase) {
        this.createFincaUseCase = createFincaUseCase;
        this.deleteFincaUseCase = deleteFincaUseCase;
        this.getFincaUseCase = getFincaUseCase;
        this.updateFincaUseCase = updateFincaUseCase;
    }

    @Override
    public Finca createFinca(Finca finca) {
        return createFincaUseCase.createFinca(finca);
    }

    @Override
    public boolean deleteFincaById(int id) {
        return deleteFincaUseCase.deleteFincaById(id);
    }

    @Override
    public List<Finca> getAllFincas() {
        return getFincaUseCase.getAllFincas();
    }

    @Override
    public Optional<Finca> getFincaById(int id) {
        return getFincaUseCase.getFincaById(id);
    }

    @Override
    public Optional<Finca> updateFinca(int id, Finca finca) {
        return updateFincaUseCase.updateFinca(id, finca);
    }
}
