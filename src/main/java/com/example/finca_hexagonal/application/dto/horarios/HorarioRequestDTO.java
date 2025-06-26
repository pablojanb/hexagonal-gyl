package com.example.finca_hexagonal.application.dto.horarios;

import java.math.BigDecimal;
import java.sql.Time;

public class HorarioRequestDTO {
    private Long id_finca;
    private Time hora_inicio;
    private Time hora_fin;
    private String dia_Semana;
    private BigDecimal descuento;
    private BigDecimal recargo;
}
