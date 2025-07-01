package com.example.finca_hexagonal.application.usecases.fechaEspecial;

import com.example.finca_hexagonal.domain.ports.in.fechaEspecial.DeleteFechaEspecialUseCase;
import com.example.finca_hexagonal.domain.ports.out.FechaEspecialModelPort;
import org.springframework.stereotype.Service;


@Service
public class DeleteFechaEspecialUseCaseImpl implements DeleteFechaEspecialUseCase {

    private final FechaEspecialModelPort fechaEspecialModelPort;

    public DeleteFechaEspecialUseCaseImpl(FechaEspecialModelPort fechaEspecialModelPort) {
        this.fechaEspecialModelPort = fechaEspecialModelPort;
    }


    @Override
    public boolean deleteFechaEspecial(Long id) {
        return fechaEspecialModelPort.deleteFechaEspecial(id);
    }
}
