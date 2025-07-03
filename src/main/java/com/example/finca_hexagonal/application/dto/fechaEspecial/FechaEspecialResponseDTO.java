package com.example.finca_hexagonal.application.dto.fechaEspecial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FechaEspecialResponseDTO {
    private Long id;
    private Long fincaId;
    private String finca;
    private LocalDate fecha;
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private BigDecimal descuento;
    private BigDecimal recargo;
    private String motivo;
}
