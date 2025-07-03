package com.example.finca_hexagonal.application.services.permiso.impl;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.in.permiso.CreatePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.in.permiso.DeletePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.in.permiso.GetPermisoUseCase;
import com.example.finca_hexagonal.domain.ports.in.permiso.UpdatePermisoUseCase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PermisoModelService implements CreatePermisoUseCase, GetPermisoUseCase, UpdatePermisoUseCase, DeletePermisoUseCase {

    private final CreatePermisoUseCase createPermisoUseCase;
    private final GetPermisoUseCase getPermisoUseCase;
    private final UpdatePermisoUseCase updatePermisoUseCase;
    private final DeletePermisoUseCase deletePermisoUseCase;

    public PermisoModelService(CreatePermisoUseCase createPermisoUseCase, GetPermisoUseCase getPermisoUseCase, UpdatePermisoUseCase updatePermisoUseCase, DeletePermisoUseCase deletePermisoUseCase) {
        this.createPermisoUseCase = createPermisoUseCase;
        this.getPermisoUseCase = getPermisoUseCase;
        this.updatePermisoUseCase = updatePermisoUseCase;
        this.deletePermisoUseCase = deletePermisoUseCase;
    }


    @Override
    public Permiso createPermiso(Permiso permiso) {
        permiso.setRoles(new ArrayList<>());
        return createPermisoUseCase.createPermiso(permiso);
    }

    @Override
    public boolean deletePermiso(Long id) {
        return deletePermisoUseCase.deletePermiso(id);
    }

    @Override
    public List<Permiso> getAllPermisos() {
        return getPermisoUseCase.getAllPermisos();
    }

    @Override
    public Optional<Permiso> getPermiso(Long id) {
        return getPermisoUseCase.getPermiso(id);
    }

    @Override
    public Optional<Permiso> updatePermiso(Long id, Permiso updatePermiso) {
        return updatePermisoUseCase.updatePermiso(id, updatePermiso);
    }
}
