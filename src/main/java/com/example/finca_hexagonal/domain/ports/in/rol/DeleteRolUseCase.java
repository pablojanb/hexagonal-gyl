package com.example.finca_hexagonal.domain.ports.in.rol;

import com.example.finca_hexagonal.domain.models.Rol;
public interface DeleteRolUseCase {
    Boolean deleteById(Long id);
    Rol logicalDeletion(Rol rol);
}
