package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "roles")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    @ManyToMany
    @JoinTable(
            name = "rol_permiso",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "permiso_id")
    )
    private List<PermisoEntity> permisos;

    public RolEntity() {
    }

    public RolEntity(Long id, String nombre, List<PermisoEntity> permisos) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permisos;
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

    public List<PermisoEntity> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<PermisoEntity> permisos) {
        this.permisos = permisos;
    }
}
