package com.example.finca_hexagonal.application.usecases.permiso;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.in.permiso.UpdatePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;

public class UpdatePermisoUseCaseImpl implements UpdatePermisoUseCase {

    private final PermisoModelPort permisoModelPort;

    public UpdatePermisoUseCaseImpl(PermisoModelPort permisoModelPort) {
        this.permisoModelPort = permisoModelPort;
    }

    @Override
    public Permiso updatePermiso(Permiso permiso) {
        return permisoModelPort.update(permiso);
    }
}
