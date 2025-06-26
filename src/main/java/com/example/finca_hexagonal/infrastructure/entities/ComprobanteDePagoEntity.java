package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "comprobante_de_pago")

public class ComprobanteDePagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pago_id")
    private PagoEntity pago;

    @ManyToOne
    @JoinColumn(name = "modo_de_pago_id")
    private  ModoDePagoEntity modoDePago;

    private String descripcion;
    private BigDecimal monto;
}
