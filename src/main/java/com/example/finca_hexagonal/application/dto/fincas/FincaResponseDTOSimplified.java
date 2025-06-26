package com.example.finca_hexagonal.application.dto.fincas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FincaResponseDTOSimplified {
    private Long id;
    private String nombre;
    private Long id_propietario;
    private String propietario;
    private Long id_direccion;
    private String direccion;
    private BigDecimal tarifa_hora;
    private Long id_detalle;
}
