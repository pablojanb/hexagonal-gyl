package com.example.finca_hexagonal.application.dto.usuario;


import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;

import java.util.Set;

public record UsuarioResponseDTO(Long id,
                                 String username,
                                 String email,
                                 Set<RolResponseDTO>  permisoSet,
                                 boolean enabled) {
}
