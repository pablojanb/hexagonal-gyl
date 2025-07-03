package com.example.finca_hexagonal.domain.models;

import java.math.BigDecimal;

public class Finca {
    private Long id;
    private String nombre;
    private Usuario usuario;
    private Direccion direccion;
    private BigDecimal tarifaHora;

    public Finca() {
    }

    public Finca(Long id, String nombre, Usuario usuario, Direccion direccion, BigDecimal tarifaHora) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.direccion = direccion;
        this.tarifaHora = tarifaHora;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(BigDecimal tarifaHora) {
        this.tarifaHora = tarifaHora;
    }
}