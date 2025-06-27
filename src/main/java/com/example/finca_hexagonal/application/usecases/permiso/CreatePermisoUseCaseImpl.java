package com.example.finca_hexagonal.application.usecases.permiso;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.in.permiso.CreatePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;

public class CreatePermisoUseCaseImpl implements CreatePermisoUseCase{

    private final PermisoModelPort permisoModelPort;

    public CreatePermisoUseCaseImpl(PermisoModelPort permisoModelPort) {
        this.permisoModelPort = permisoModelPort;
    }

    @Override
    public Permiso createPermiso(Permiso permiso) {
        return permisoModelPort.save(permiso);
    }
}
