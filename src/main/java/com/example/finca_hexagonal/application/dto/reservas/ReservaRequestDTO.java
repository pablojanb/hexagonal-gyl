package com.example.finca_hexagonal.application.dto.reservas;

import com.example.finca_hexagonal.domain.models.enums.EstadoReserva;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaRequestDTO {
    private Long idFinca;
    private Long idUsuario;
    private String diaSemana;
    private LocalDate fecha;
    private LocalTime desde;
    private LocalTime hasta;
    private BigDecimal descuento = BigDecimal.valueOf(0);
    private BigDecimal recargo = BigDecimal.valueOf(0);
    private String detalle = "";
    private EstadoReserva estadoReserva = EstadoReserva.PENDING;
}
