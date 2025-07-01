package com.example.finca_hexagonal.application.dto.rol;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record RolRequestDTO(@NotBlank String nombre, @NotNull Set<Long> permisoIdSet) {
}


