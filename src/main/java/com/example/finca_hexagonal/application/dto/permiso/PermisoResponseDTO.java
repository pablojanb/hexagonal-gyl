package com.example.finca_hexagonal.application.dto.permiso;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id,nombre"})
public record PermisoResponseDTO (Long id, String nombre){
}
