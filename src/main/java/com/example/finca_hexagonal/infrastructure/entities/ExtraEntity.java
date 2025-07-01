package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "extras")
public class ExtraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "finca_extra",
            joinColumns = @JoinColumn(name = "extra_id"),
            inverseJoinColumns = @JoinColumn(name = "finca_id")
    )
    private List<FincaEntity> fincas;

    public ExtraEntity() {
    }

    public ExtraEntity(Long id, String nombre, List<FincaEntity> fincas) {
        this.id = id;
        this.nombre = nombre;
        this.fincas = fincas;
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

    public List<FincaEntity> getFincas() {
        return fincas;
    }

    public void setFincas(List<FincaEntity> fincas) {
        this.fincas = fincas;
    }
}
