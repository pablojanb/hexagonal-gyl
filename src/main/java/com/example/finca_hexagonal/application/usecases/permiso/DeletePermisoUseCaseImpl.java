package com.example.finca_hexagonal.application.usecases.permiso;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.in.permiso.DeletePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;

public class DeletePermisoUseCaseImpl implements DeletePermisoUseCase {

    private final PermisoModelPort permisoModelPort;

     public DeletePermisoUseCaseImpl(PermisoModelPort permisoModelPort) {
         this.permisoModelPort = permisoModelPort;
     }

    @Override
    public Boolean deletePermisoById(Long id) {
         return permisoModelPort.deleteById(id);
    }
}
