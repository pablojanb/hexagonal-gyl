package com.example.finca_hexagonal.application.usecases.permiso;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.in.permiso.GetPermisoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetPermisoUseCaseImpl implements GetPermisoUseCase {
    private final PermisoModelPort permisoModelPort;

    public GetPermisoUseCaseImpl(PermisoModelPort permisoModelPort) {
        this.permisoModelPort = permisoModelPort;
    }
    @Override
    public List<Permiso> getAllPermisos() {
        return permisoModelPort.findAll();
    }

    @Override
    public Optional<Permiso> getPermiso(Long id) {
        return permisoModelPort.findById(id);
    }
}
