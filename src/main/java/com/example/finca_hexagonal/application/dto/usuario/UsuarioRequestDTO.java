package com.example.finca_hexagonal.application.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(@NotBlank String username,
                                @NotBlank String email,
                                @NotBlank String password) {
}
