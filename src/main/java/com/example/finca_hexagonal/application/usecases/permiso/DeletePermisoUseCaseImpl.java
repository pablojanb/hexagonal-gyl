package com.example.finca_hexagonal.application.usecases.permiso;

import com.example.finca_hexagonal.domain.ports.in.permiso.DeletePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeletePermisoUseCaseImpl implements DeletePermisoUseCase {
    private final PermisoModelPort permisoModelPort;

    public DeletePermisoUseCaseImpl(PermisoModelPort permisoModelPort) {
        this.permisoModelPort = permisoModelPort;
    }
    @Override
    public boolean deletePermiso(Long id) {
        return permisoModelPort.deleteById(id);
    }
}
