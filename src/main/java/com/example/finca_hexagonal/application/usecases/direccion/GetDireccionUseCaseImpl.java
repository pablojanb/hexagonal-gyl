package com.example.finca_hexagonal.application.usecases.direccion;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.ports.in.direccion.GetDireccionUseCase;
import com.example.finca_hexagonal.domain.ports.out.DireccionModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetDireccionUseCaseImpl implements GetDireccionUseCase {

    private final DireccionModelPort direccionModelPort;

    public GetDireccionUseCaseImpl(DireccionModelPort direccionModelPort) {
        this.direccionModelPort = direccionModelPort;
    }

    @Override
    public List<Direccion> getAllDirecciones() {
        return direccionModelPort.findAll();
    }

    @Override
    public Optional<Direccion> getDireccionById(Long id) {
        return direccionModelPort.findById(id);
    }
}
