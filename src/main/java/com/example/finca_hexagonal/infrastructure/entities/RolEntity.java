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
    @ManyToMany
    @JoinTable(
            name = "rol_usuario",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<UsuarioEntity> usuarios;

    public RolEntity() {
    }

    public RolEntity(Long id, String nombre, List<PermisoEntity> permisos, List<UsuarioEntity> usuarios) {
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

    public List<PermisoEntity> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<PermisoEntity> permisos) {
        this.permisos = permisos;
    }

    public List<UsuarioEntity> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }
}
