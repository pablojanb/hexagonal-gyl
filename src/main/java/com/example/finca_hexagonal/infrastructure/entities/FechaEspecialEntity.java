package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fechas_especiales")
public class FechaEspecialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "finca_id")
    private FincaEntity finca;
    private LocalDate fecha;
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private BigDecimal descuento;
    private BigDecimal recargo;
    private String motivo;
}
