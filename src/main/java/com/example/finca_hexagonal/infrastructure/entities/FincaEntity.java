package com.example.finca_hexagonal.infrastructure.entities;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.models.Propietario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class FincaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    @OneToOne
    private Propietario propietario;
    @OneToOne
    private DetalleFinca detalle;
    @OneToOne
    private Direccion direccion;
    private BigDecimal tarifa_hora;
}
