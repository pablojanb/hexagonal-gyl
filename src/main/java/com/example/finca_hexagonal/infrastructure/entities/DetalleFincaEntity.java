package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalle_finca")
public class DetalleFincaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    private String descripcion;
    private int cantHabitacion;
    private int cantBano;
    private double metrosCuadrados;
    private int capacidadMaxima;
    private boolean wifi;
    private boolean piscina;
    private boolean parrilla;
}
