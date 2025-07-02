package com.example.finca_hexagonal.application.usecases.direccion;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.ports.in.direccion.UpdateDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.out.DireccionModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateDireccionUseCaseImpl implements UpdateDireccionUseCase {

    private final DireccionModelPort direccionModelPort;

    public UpdateDireccionUseCaseImpl(DireccionModelPort direccionModelPort) {
        this.direccionModelPort = direccionModelPort;
    }

    @Override
    public Optional<Direccion> updateDireccion(Long id, Direccion updateDireccion) {
        return direccionModelPort.updateById(id, updateDireccion);
    }
}
