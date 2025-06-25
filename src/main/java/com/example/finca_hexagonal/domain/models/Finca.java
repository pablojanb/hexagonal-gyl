package com.example.finca_hexagonal.domain.models;

import java.math.BigDecimal;

public class Finca {
    private int id;
    private String nombre;
    private Propietario propietario;
    private DetalleFinca detalle;
    private Direccion direccion;
    private BigDecimal tarifa_hora;

    public Finca() {
    }

    public Finca(int id, String nombre, Propietario propietario, DetalleFinca detalle, Direccion direccion, BigDecimal tarifa_hora) {
        this.id = id;
        this.nombre = nombre;
        this.propietario = propietario;
        this.detalle = detalle;
        this.direccion = direccion;
        this.tarifa_hora = tarifa_hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public DetalleFinca getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleFinca detalle) {
        this.detalle = detalle;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getTarifa_hora() {
        return tarifa_hora;
    }

    public void setTarifa_hora(BigDecimal tarifa_hora) {
        this.tarifa_hora = tarifa_hora;
    }
}