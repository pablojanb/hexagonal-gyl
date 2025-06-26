package com.example.finca_hexagonal.domain.models;

import java.util.Set;

public class Rol {
    private int id;
    private String nombre;
    private Set<Permiso> permisoSet;

    public Rol(int id, String nombre, Set<Permiso> permisoSet){
        this.id = id;
        this.nombre = nombre;
        this.permisoSet = permisoSet;
    }

    public Rol(){}

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

    public Set<Permiso> getPermisoSet() {
        return permisoSet;
    }

    public void setPermisoSet(Set<Permiso> permisoSet) {
        this.permisoSet = permisoSet;
    }
}