package com.example.finca_hexagonal.application.usecases.permiso;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.in.permiso.UpdatePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePermisoUseCaseImpl implements UpdatePermisoUseCase {
    private final PermisoModelPort permisoModelPort;

    public UpdatePermisoUseCaseImpl(PermisoModelPort permisoModelPort) {
        this.permisoModelPort = permisoModelPort;
    }
    @Override
    public Optional<Permiso> updatePermiso(Long id, Permiso updatePermiso) {
        return permisoModelPort.updateById(id, updatePermiso);
    }
}
