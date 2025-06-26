package com.example.finca_hexagonal.domain.ports.in.permiso;


import com.example.finca_hexagonal.domain.models.Permiso;

public interface CreatePermisoUseCase {
    void createPermiso(Permiso permiso);
}
