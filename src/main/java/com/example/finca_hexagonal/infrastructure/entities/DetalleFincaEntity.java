package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_finca")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleFincaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private int cantHabitacion;
    private int cantBano;
    private double metrosCuadrados;
    private int capacidadMaxima;

}
