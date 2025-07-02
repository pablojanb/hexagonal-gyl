package com.example.finca_hexagonal.application.usecases.direccion;

import com.example.finca_hexagonal.domain.ports.in.direccion.DeleteDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.out.DireccionModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteDireccionUseCaseImpl implements DeleteDireccionUseCase {

    private final DireccionModelPort direccionModelPort;

    public DeleteDireccionUseCaseImpl(DireccionModelPort direccionModelPort) {
        this.direccionModelPort = direccionModelPort;
    }

    @Override
    public boolean deleteDireccion(Long id) {
        return direccionModelPort.deleteById(id);
    }
}

