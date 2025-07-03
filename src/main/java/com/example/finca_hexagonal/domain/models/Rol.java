package com.example.finca_hexagonal.domain.models;

import java.util.List;

public class Rol {
    private Long id;
    private String nombre;
    private List<Permiso> permisos;
    private List<Usuario> usuarios;

    public Rol() {
    }

    public Rol(Long id, String nombre, List<Permiso> permisos, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permisos;
        this.usuarios = usuarios;
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

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
