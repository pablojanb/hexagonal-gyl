package com.example.finca_hexagonal.application.services.fecha_especial.impl;


import com.example.finca_hexagonal.domain.models.Fecha_Especial;
import com.example.finca_hexagonal.domain.ports.in.fecha_Especial.CreateFecha_EspecialUseCase;
import com.example.finca_hexagonal.domain.ports.in.fecha_Especial.DeleteFecha_EspecialUseCase;
import com.example.finca_hexagonal.domain.ports.in.fecha_Especial.FindFecha_EspecialUseCase;
import com.example.finca_hexagonal.domain.ports.in.fecha_Especial.UpdateFecha_EspecialUseCase;

import java.util.List;
import java.util.Optional;

// todos Implementa los casos de uso
public class Fecha_EspecialModelService implements CreateFecha_EspecialUseCase, DeleteFecha_EspecialUseCase, UpdateFecha_EspecialUseCase, FindFecha_EspecialUseCase {
     private CreateFecha_EspecialUseCase createFecha_EspecialUseCase;
     private DeleteFecha_EspecialUseCase deleteFecha_EspecialUseCase;
     private UpdateFecha_EspecialUseCase updateFecha_EspecialUseCase;
     private FindFecha_EspecialUseCase findFecha_EspecialUseCase;


    public Fecha_EspecialModelService(CreateFecha_EspecialUseCase createFecha_EspecialUseCase, DeleteFecha_EspecialUseCase deleteFecha_EspecialUseCase, UpdateFecha_EspecialUseCase updateFecha_EspecialUseCase, FindFecha_EspecialUseCase findFecha_EspecialUseCase) {
        this.createFecha_EspecialUseCase = createFecha_EspecialUseCase;
        this.deleteFecha_EspecialUseCase = deleteFecha_EspecialUseCase;
        this.updateFecha_EspecialUseCase = updateFecha_EspecialUseCase;
        this.findFecha_EspecialUseCase = findFecha_EspecialUseCase;
    }



    @Override
    public boolean delete(Long id_fecha) {
        return false;
    }

    @Override
    public List<Fecha_Especial> getAll() {
        return List.of();
    }

    @Override
    public Optional<Fecha_Especial> getById(Long id_fecha) {
        return Optional.empty();
    }

    @Override
    public Fecha_Especial update(Fecha_Especial fecha_Especial) {
        return null;
    }

    @Override
    public Fecha_Especial create(Fecha_Especial fecha_Especial) {
        return null;
    }
}
