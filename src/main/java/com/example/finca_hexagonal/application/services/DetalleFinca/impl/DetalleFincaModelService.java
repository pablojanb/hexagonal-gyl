package com.example.finca_hexagonal.application.services.DetalleFinca.impl;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.ports.in.detalleFinca.CreateDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.detalleFinca.DeleteDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.detalleFinca.FindDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.detalleFinca.UpdateDetalleFincaUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFincaModelService implements CreateDetalleFincaUseCase, FindDetalleFincaUseCase, DeleteDetalleFincaUseCase, UpdateDetalleFincaUseCase {
    private final  CreateDetalleFincaUseCase createDetalleFincaUseCase;
    private final FindDetalleFincaUseCase findDetalleFincaUseCase;
    private final DeleteDetalleFincaUseCase deleteDetalleFincaUseCase;
    private final UpdateDetalleFincaUseCase updateDetalleFincaUseCase;

    public DetalleFincaModelService(CreateDetalleFincaUseCase createDetalleFincaUseCase, FindDetalleFincaUseCase findDetalleFincaUseCase, DeleteDetalleFincaUseCase deleteDetalleFincaUseCase, UpdateDetalleFincaUseCase updateDetalleFincaUseCase) {
        this.createDetalleFincaUseCase = createDetalleFincaUseCase;
        this.findDetalleFincaUseCase = findDetalleFincaUseCase;
        this.deleteDetalleFincaUseCase = deleteDetalleFincaUseCase;
        this.updateDetalleFincaUseCase = updateDetalleFincaUseCase;
    }

    @Override
    public DetalleFinca create(DetalleFinca detalleFinca) {
        return createDetalleFincaUseCase.create(detalleFinca);
    }

    @Override
    public boolean delete(Long id) {
        return deleteDetalleFincaUseCase.delete(id);
    }

    @Override
    public List<DetalleFinca> getAll() {
        return findDetalleFincaUseCase.getAll();
    }

    @Override
    public Optional<DetalleFinca> getById(Long id) {
        return findDetalleFincaUseCase.getById(id);
    }

    @Override
    public Optional<DetalleFinca> update(Long id, DetalleFinca detalleFinca) {
        return updateDetalleFincaUseCase.update(id, detalleFinca);
    }
}
