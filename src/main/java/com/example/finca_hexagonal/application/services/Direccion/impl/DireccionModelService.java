package com.example.finca_hexagonal.application.services.Direccion.impl;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.ports.in.direccion.CreateDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.in.direccion.DeleteDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.in.direccion.GetDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.in.direccion.UpdateDireccionUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DireccionModelService implements CreateDireccionUseCase, GetDireccionUseCase, UpdateDireccionUseCase, DeleteDireccionUseCase {

    private final CreateDireccionUseCase createDireccionUseCase;
    private final GetDireccionUseCase getDireccionUseCase;
    private final UpdateDireccionUseCase updateDireccionUseCase;
    private final DeleteDireccionUseCase deleteDireccionUseCase;

    public DireccionModelService(CreateDireccionUseCase createDireccionUseCase, GetDireccionUseCase getDireccionUseCase, UpdateDireccionUseCase updateDireccionUseCase, DeleteDireccionUseCase deleteDireccionUseCase) {
        this.createDireccionUseCase = createDireccionUseCase;
        this.getDireccionUseCase = getDireccionUseCase;
        this.updateDireccionUseCase = updateDireccionUseCase;
        this.deleteDireccionUseCase = deleteDireccionUseCase;
    }

    @Override
    public Direccion createDireccion(Direccion direccion) {
        return createDireccionUseCase.createDireccion(direccion);
    }

    @Override
    public boolean deleteDireccion(Long id) {
        return deleteDireccionUseCase.deleteDireccion(id);
    }

    @Override
    public List<Direccion> getAllDirecciones() {
        return getDireccionUseCase.getAllDirecciones();
    }

    @Override
    public Optional<Direccion> getDireccionById(Long id) {
        return getDireccionUseCase.getDireccionById(id);
    }

    @Override
    public Optional<Direccion> updateDireccion(Long id, Direccion updateDireccion) {
        return updateDireccionUseCase.updateDireccion(id, updateDireccion);
    }
}
