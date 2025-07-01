package com.example.finca_hexagonal.application.usecases.fechaEspecial;

import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.ports.in.fechaEspecial.UpdateFechaEspecialUseCase;
import com.example.finca_hexagonal.domain.ports.out.FechaEspecialModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateFechaEspecialUseCaseImpl implements UpdateFechaEspecialUseCase {
    private final FechaEspecialModelPort fechaEspecialModelPort;

    public UpdateFechaEspecialUseCaseImpl(FechaEspecialModelPort fechaEspecialModelPort) {
        this.fechaEspecialModelPort = fechaEspecialModelPort;
    }

    @Override
    public Optional<FechaEspecial> update(Long id, FechaEspecial fechaEspecial) {
        return fechaEspecialModelPort.update(id, fechaEspecial);
    }
}
