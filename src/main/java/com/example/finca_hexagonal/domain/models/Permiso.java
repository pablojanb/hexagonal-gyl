package com.example.finca_hexagonal.domain.models;

public class Permiso {
    private int id;
    private String nombre;

    public Permiso(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    public Permiso(){}

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}