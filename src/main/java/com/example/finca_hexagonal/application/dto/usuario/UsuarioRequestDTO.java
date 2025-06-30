package com.example.finca_hexagonal.application.dto.usuario;

import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UsuarioRequestDTO(@NotBlank String username,
                                @NotBlank String email,
                                @NotBlank String password,
                                @NotNull Set<Long> rolIdSet) {
}
