package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "finca_id")
    private FincaEntity finca;
    @Temporal(TemporalType.TIME)
    private Time hora_inicio;
    @Temporal(TemporalType.TIME)
    private Time hora_fin;
    private String dia_Semana;
    private BigDecimal descuento;
    private BigDecimal recargo;
}
