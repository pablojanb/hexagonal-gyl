package com.example.finca_hexagonal.application.dto.permiso;

import jakarta.validation.constraints.NotBlank;

public record PermisoRequestDTO(@NotBlank String name) {
}
