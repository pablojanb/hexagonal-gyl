package com.example.finca_hexagonal.infrastructure.entities;


import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "permisos")
public class PermisoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    @ManyToMany
    private List<RolEntity> roles;

    public PermisoEntity() {
    }

    public PermisoEntity(Long id, String nombre, List<RolEntity> roles) {
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

    public List<RolEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RolEntity> roles) {
        this.roles = roles;
    }
}
