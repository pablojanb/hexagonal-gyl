package com.example.finca_hexagonal.application.dto.horarios;

import java.math.BigDecimal;
import java.sql.Time;

public class HorarioResponseDTO {
    private Long id;
    private Long id_finca;
    private String finca;
    private Time hora_inicio;
    private Time hora_fin;
    private String dia_Semana;
    private BigDecimal descuento;
    private BigDecimal recargo;
}
