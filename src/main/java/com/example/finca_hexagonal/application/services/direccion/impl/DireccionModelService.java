package com.example.finca_hexagonal.application.services.direccion.impl;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.ports.in.direccion.CreateDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.in.direccion.DeleteDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.in.direccion.FindDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.in.direccion.UpdateDireccionUseCase;

import java.util.List;
import java.util.Optional;

public class DireccionModelService implements CreateDireccionUseCase, UpdateDireccionUseCase, DeleteDireccionUseCase, FindDireccionUseCase {

    private CreateDireccionUseCase createDireccionUseCase;
    private UpdateDireccionUseCase updateDireccionUseCase;
    private DeleteDireccionUseCase deleteDireccionUseCase;
    private FindDireccionUseCase findDireccionUseCase;

    public DireccionModelService(CreateDireccionUseCase createDireccionUseCase, UpdateDireccionUseCase updateDireccionUseCase, DeleteDireccionUseCase deleteDireccionUseCase, FindDireccionUseCase findDireccionUseCase) {
        this.createDireccionUseCase = createDireccionUseCase;
        this.updateDireccionUseCase = updateDireccionUseCase;
        this.deleteDireccionUseCase = deleteDireccionUseCase;
        this.findDireccionUseCase = findDireccionUseCase;

    }

    @Override
    public Direccion create(Direccion direccion) {
        return null;
    }

    @Override
    public boolean delete(Long id_direccion) {
        return false;
    }


    @Override
    public List<Direccion> getAll() {
        return List.of();
    }

    @Override
    public Optional<Direccion> findById(Long id_direccion) {
        return Optional.empty();
    }

    @Override
    public Optional<Direccion> findByAltura(int altura) {
        return Optional.empty();
    }

    @Override
    public Direccion update(Direccion direccion) {
        return null;
    }
}
