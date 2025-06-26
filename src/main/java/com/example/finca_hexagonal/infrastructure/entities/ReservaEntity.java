package com.example.finca_hexagonal.infrastructure.entities;

import com.example.finca_hexagonal.infrastructure.entities.FincaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "finca_id")
    private FincaEntity finca;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    private Date desde;
    private Date hasta;
    private BigDecimal total;
    private Boolean estadoReserva;
}
