package com.example.finca_hexagonal.infrastructure.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "pago")
public class PagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private ReservaEntity reserva;

    private BigDecimal monto_total;

    @OneToOne
    @JoinColumn(name = "modoPago_id")
    private ModoDePagoEntity modoDePago;

    private LocalDateTime fecha_hora;

    private BigDecimal descuento_aplicado;

    private BigDecimal recargo_aplicado;

    private boolean estado_pago;

}
