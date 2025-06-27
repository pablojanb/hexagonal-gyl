package com.example.finca_hexagonal.domain.models;

public class Permiso {
    private Long id;
    private String nombre;

    public Permiso(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    public Permiso(){}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}