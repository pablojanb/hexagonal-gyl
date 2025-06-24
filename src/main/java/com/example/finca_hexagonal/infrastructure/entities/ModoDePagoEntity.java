package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;


public class ModoDePagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name="pago_id")
    private PagoEntity pago;

    private String tipo;
    private  String detalles;
}
