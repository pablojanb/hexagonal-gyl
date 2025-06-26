package com.example.finca_hexagonal.application.services.DetalleFinca.impl;

import com.example.finca_hexagonal.domain.models.DetalleFinca;

import com.example.finca_hexagonal.domain.ports.in.detalle_finca.CreateDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.detalle_finca.DeleteDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.detalle_finca.FindDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.in.detalle_finca.UpdateDetalleFincaUseCase;

import java.util.List;
import java.util.Optional;

public class DetalleFincaModelService implements CreateDetalleFincaUseCase, DeleteDetalleFincaUseCase, UpdateDetalleFincaUseCase, FindDetalleFincaUseCase {

    private final CreateDetalleFincaUseCase createDetalleFincaUseCase;
    private final DeleteDetalleFincaUseCase deleteDetalleFincaUseCase;
    private final FindDetalleFincaUseCase findDetalleFincaUseCase;
    private final UpdateDetalleFincaUseCase updateDetalleFincaUseCase;

    public DetalleFincaModelService(CreateDetalleFincaUseCase createDetalleFincaUseCase, DeleteDetalleFincaUseCase deleteDetalleFincaUseCase, FindDetalleFincaUseCase findDetalleFincaUseCase, UpdateDetalleFincaUseCase updateDetalleFincaUseCase) {
        this.createDetalleFincaUseCase = createDetalleFincaUseCase;
        this.deleteDetalleFincaUseCase = deleteDetalleFincaUseCase;
        this.updateDetalleFincaUseCase = updateDetalleFincaUseCase;
        this.findDetalleFincaUseCase = findDetalleFincaUseCase;
    }

    @Override
    public DetalleFinca create(DetalleFinca detalleFinca){return createDetalleFincaUseCase.create(detalleFinca);}

    @Override
    public DetalleFinca delete(DetalleFinca detalleFinca){return deleteDetalleFincaUseCase.delete(detalleFinca);}

    @Override
    public List<DetalleFinca> getAll(){return findDetalleFincaUseCase.getAll();}

    @Override
    public Optional<DetalleFinca> getById(Long Id) {
        return Optional.empty();
    }

    @Override
    public DetalleFinca update(DetalleFinca detalleFinca){return updateDetalleFincaUseCase.update(detalleFinca);}
}
