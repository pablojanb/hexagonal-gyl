package com.example.finca_hexagonal.infrastructure.entities;

import com.example.finca_hexagonal.domain.models.enums.EstadoPago;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pago")
public class PagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private ReservaEntity reserva;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @OneToOne
    @JoinColumn(name = "medio_de_pago_id")
    private ModoDePagoEntity modoDePago;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaPago;

    @Column(name = "descuento_aplicado")
    private BigDecimal descuentoAplicado;

    @Column(name = "recargo_aplicado")
    private BigDecimal recargoAplicado;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago")
    private EstadoPago estadoPago;
}
