package com.example.finca_hexagonal.application.usecases.direccion;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.ports.in.direccion.CreateDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.out.DireccionModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateDireccionUseCaseImpl implements CreateDireccionUseCase {

    private final DireccionModelPort direccionModelPort;

    public CreateDireccionUseCaseImpl(DireccionModelPort direccionModelPort) {
        this.direccionModelPort = direccionModelPort;
    }

    @Override
    public Direccion createDireccion(Direccion direccion) {
        return direccionModelPort.saveDireccion(direccion);
    }
}
