package com.example.finca_hexagonal.application.services.rol.impl;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.in.rol.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolModelService implements CreateRolUseCase, GetRolUseCase, UpdateRolUseCase, DeleteRolUseCase {

    private final CreateRolUseCase createRolUseCase;
    private final GetRolUseCase getRolUseCase;
    private final UpdateRolUseCase updateRolUseCase;
    private final DeleteRolUseCase deleteRolUseCase;

    public RolModelService(CreateRolUseCase createRolUseCase, GetRolUseCase getRolUseCase, UpdateRolUseCase updateRolUseCase, DeleteRolUseCase deleteRolUseCase) {
        this.createRolUseCase = createRolUseCase;
        this.getRolUseCase = getRolUseCase;
        this.updateRolUseCase = updateRolUseCase;
        this.deleteRolUseCase = deleteRolUseCase;
    }

    @Override
    public Rol createRol(Rol rol) {
        rol.setUsuarios(new ArrayList<>());
        rol.setPermisos(new ArrayList<>());
        return createRolUseCase.createRol(rol);
    }

    @Override
    public boolean deleteRol(Long id) {
        return deleteRolUseCase.deleteRol(id);
    }

    @Override
    public List<Rol> getRoles() {
        return getRolUseCase.getRoles();
    }

    @Override
    public Optional<Rol> getRol(Long id) {
        return getRolUseCase.getRol(id);
    }

    @Override
    public Optional<Rol> updateRol(Long id, Rol rolUpdate) {
        return updateRolUseCase.updateRol(id, rolUpdate);
    }

}
