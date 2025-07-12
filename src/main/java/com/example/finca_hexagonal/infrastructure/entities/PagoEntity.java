package com.example.finca_hexagonal.infrastructure.entities;

import com.example.finca_hexagonal.domain.models.enums.EstadoPago;
import com.example.finca_hexagonal.domain.models.enums.MedioPago;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pago")
public class PagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "reserva_id")
    private ReservaEntity reserva;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @Column(name = "monto")
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "medio_pago")
    private MedioPago medioPago;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaPago;

    @Column(name = "descuento_aplicado")
    private BigDecimal descuentoAplicado;

    @Column(name = "recargo_aplicado")
    private BigDecimal recargoAplicado;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago")
    private EstadoPago estadoPago;

    @ElementCollection
    @CollectionTable(name = "pago_intentos", joinColumns = @JoinColumn(name = "pago_id"))
    @Column(name = "detalle")
    private List<String> detalles = new ArrayList<>();
}
