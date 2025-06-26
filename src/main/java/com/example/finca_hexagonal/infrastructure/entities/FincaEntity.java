package com.example.finca_hexagonal.infrastructure.entities;

import com.example.finca_hexagonal.domain.models.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class FincaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    @OneToOne
    private PropietarioEntity propietario;
    @OneToOne
    private DetalleFincaEntity detalle;
    @OneToOne
    private DireccionEntity direccion;
    private BigDecimal tarifa_hora;

    @OneToMany(mappedBy = "finca")
    private List<HorarioEntity> horarios;

    @OneToMany(mappedBy = "finca")
    private List<ImagenFincaEntity> imagenesFinca;

    @OneToMany(mappedBy = "finca")
    private List<Fecha_EspecialEntity> fechasEspFinca;

    @OneToMany(mappedBy = "finca")
    private List<ReservaEntity> reservasFinca;
}
