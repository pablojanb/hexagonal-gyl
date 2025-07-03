package com.example.finca_hexagonal.domain.models;

import java.util.List;

public class Permiso {
    private Long id;
    private String nombre;
    private List<Rol> roles;

    public Permiso() {
    }

    public Permiso(Long id, String nombre, List<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.roles = roles;
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

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
