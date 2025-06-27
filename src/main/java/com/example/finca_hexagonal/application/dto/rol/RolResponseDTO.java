package com.example.finca_hexagonal.application.dto.rol;

import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;

import java.util.Set;

public record RolResponseDTO (Long id, String nombre, Set<PermisoResponseDTO> permisoSet) {
}
