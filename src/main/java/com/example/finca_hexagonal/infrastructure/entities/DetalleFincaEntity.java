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
    @Column(name = "id_detalle")
    private Long idDetalle;

    private String descripcion;

    @Column(name = "cant_habitacion")
    private int cantHabitacion;

    @Column(name = "cant_bano")
    private int cantBano;

    @Column(name = "metros_cuadrados")
    private double metrosCuadrados;

    @Column(name = "capacidad_maxima")
    private int capacidadMaxima;
}

