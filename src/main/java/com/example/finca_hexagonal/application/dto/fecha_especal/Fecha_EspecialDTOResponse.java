package com.example.finca_hexagonal.application.dto.fecha_especal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fecha_EspecialDTOResponse {
    private Long id_fecha;
    private LocalDateTime fecha;
    private LocalDateTime dia_semana;
    private LocalDateTime hora_inicio;
    private LocalDateTime hora_fin;
    private BigDecimal descuento;
    private BigDecimal recargo;
    private String motivo;
    private Long finca_id;

}
