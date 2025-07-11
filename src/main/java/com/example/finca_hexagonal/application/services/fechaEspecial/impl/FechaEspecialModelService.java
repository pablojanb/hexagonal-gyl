package com.example.finca_hexagonal.application.services.fechaEspecial.impl;

import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.ports.in.fechaEspecial.CreateFechaEspecialUseCase;
import com.example.finca_hexagonal.domain.ports.in.fechaEspecial.DeleteFechaEspecialUseCase;
import com.example.finca_hexagonal.domain.ports.in.fechaEspecial.GetFechaEspecialUseCase;
import com.example.finca_hexagonal.domain.ports.in.fechaEspecial.UpdateFechaEspecialUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FechaEspecialModelService implements CreateFechaEspecialUseCase, DeleteFechaEspecialUseCase, UpdateFechaEspecialUseCase, GetFechaEspecialUseCase {
     private final CreateFechaEspecialUseCase createFechaEspecialUseCase;
     private final DeleteFechaEspecialUseCase deleteFechaEspecialUseCase;
     private final UpdateFechaEspecialUseCase updateFechaEspecialUseCase;
     private final GetFechaEspecialUseCase getFechaEspecialUseCase;


    public FechaEspecialModelService(CreateFechaEspecialUseCase createFechaEspecialUseCase, DeleteFechaEspecialUseCase deleteFechaEspecialUseCase, UpdateFechaEspecialUseCase updateFechaEspecialUseCase, GetFechaEspecialUseCase getFechaEspecialUseCase) {
        this.createFechaEspecialUseCase = createFechaEspecialUseCase;
        this.deleteFechaEspecialUseCase = deleteFechaEspecialUseCase;
        this.updateFechaEspecialUseCase = updateFechaEspecialUseCase;
        this.getFechaEspecialUseCase = getFechaEspecialUseCase;
    }

    @Override
    public boolean deleteFechaEspecial(Long id) {
        return deleteFechaEspecialUseCase.deleteFechaEspecial(id);
    }

    @Override
    public List<FechaEspecial> getAll() {
        return getFechaEspecialUseCase.getAll();
    }

    @Override
    public Optional<FechaEspecial> getById(Long id) {
        return getFechaEspecialUseCase.getById(id);
    }

    @Override
    public List<FechaEspecial> getFechasEspByFincaId(Long fincaId) {
        return getFechaEspecialUseCase.getFechasEspByFincaId(fincaId);
    }

    @Override
    public Optional<FechaEspecial> update(Long id, FechaEspecial fechaEspecial) {
        return updateFechaEspecialUseCase.update(id, fechaEspecial);
    }

    @Override
    public FechaEspecial create(FechaEspecial fechaEspecial) {
        return createFechaEspecialUseCase.create(fechaEspecial);
    }

    @Override
    public Optional<FechaEspecial> getFechaEspecialByFincaIdAndFecha(Long fincaId, LocalDate fecha) {
        return getFechaEspecialUseCase.getFechaEspecialByFincaIdAndFecha(fincaId, fecha);
    }
}
