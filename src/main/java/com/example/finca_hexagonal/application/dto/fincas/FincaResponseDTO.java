package com.example.finca_hexagonal.application.dto.fincas;

import com.example.finca_hexagonal.domain.models.Fecha_Especial;
import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.models.Reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FincaResponseDTO {
    private Long id;
    private String nombre;
    private Long id_propietario;
    private String propietario;
    private Long id_direccion;
    private String direccion;
    private BigDecimal tarifa_hora;
    private Long id_detalle;

    private List<Horario> horarios;
    private List<ImagenFinca> imagenesFinca;
    private List<Fecha_Especial> fechasEspeciales;
    private List<Reserva> reservasFinca;
}
