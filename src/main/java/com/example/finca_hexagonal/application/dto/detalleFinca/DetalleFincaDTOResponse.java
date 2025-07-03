package com.example.finca_hexagonal.application.dto.detalleFinca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetalleFincaDTOResponse {
    private Long id;
    private Long idFinca;
    private String finca;
    private String descripcion;
    private int cantHabitacion;
    private int cantBano;
    private double metrosCuadrados;
    private int capacidadMaxima;
}
