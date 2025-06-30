package com.example.finca_hexagonal.application.usecases.permiso;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.in.permiso.FindPermisoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FindPermisoUseCaseImpl implements FindPermisoUseCase {

    private final PermisoModelPort permisoModelPort;

    public FindPermisoUseCaseImpl(PermisoModelPort permisoModelPort) {
        this.permisoModelPort = permisoModelPort;
    }

    @Override
    public Permiso findPermisoById(Long id) {
        return permisoModelPort.findById(id);
    }

    @Override
    public List<Permiso> getAllPermisos() {
        return permisoModelPort.findAll();
    }
}
