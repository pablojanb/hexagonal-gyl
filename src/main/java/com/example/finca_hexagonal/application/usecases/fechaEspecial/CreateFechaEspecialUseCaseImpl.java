package com.example.finca_hexagonal.application.usecases.fechaEspecial;

import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.ports.in.fechaEspecial.CreateFechaEspecialUseCase;
import com.example.finca_hexagonal.domain.ports.out.FechaEspecialModelPort;
import org.springframework.stereotype.Service;


@Service
public class CreateFechaEspecialUseCaseImpl implements CreateFechaEspecialUseCase {
    private final FechaEspecialModelPort fechaEspecialModelPort;

    public CreateFechaEspecialUseCaseImpl(FechaEspecialModelPort fechaEspecialModelPort) {
        this.fechaEspecialModelPort = fechaEspecialModelPort;
    }

    @Override
    public FechaEspecial create(FechaEspecial fechaEspecial) {
        return fechaEspecialModelPort.create(fechaEspecial);}

}

