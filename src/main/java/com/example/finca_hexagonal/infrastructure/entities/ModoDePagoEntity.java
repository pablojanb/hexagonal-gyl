package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "modo_de_pago")
public class ModoDePagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public ModoDePagoEntity() {}

    public ModoDePagoEntity(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
