package com.example.finca_hexagonal.domain.models;

import java.math.BigDecimal;
import java.util.List;

public class Finca {
    private Long id;
    private String nombre;
    private Propietario propietario;
    private DetalleFinca detalle;
    private Direccion direccion;
    private BigDecimal tarifaHora;

    private List<ImagenFinca> imagenesFinca;
    private List<Fecha_Especial> fechasEspeciales;
    private List<Reserva> reservasFinca;


    public Finca() {
    }

    public Finca(Long id, String nombre, Propietario propietario, DetalleFinca detalle, Direccion direccion, BigDecimal tarifaHora, List<ImagenFinca> imagenesFinca, List<Fecha_Especial> fechasEspeciales, List<Reserva> reservasFinca) {
        this.id = id;
        this.nombre = nombre;
        this.propietario = propietario;
        this.detalle = detalle;
        this.direccion = direccion;
        this.tarifaHora = tarifaHora;
        this.imagenesFinca = imagenesFinca;
        this.fechasEspeciales = fechasEspeciales;
        this.reservasFinca = reservasFinca;
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

    public BigDecimal getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(BigDecimal tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public List<ImagenFinca> getImagenesFinca() {
        return imagenesFinca;
    }

    public void setImagenesFinca(List<ImagenFinca> imagenesFinca) {
        this.imagenesFinca = imagenesFinca;
    }

    public List<Fecha_Especial> getFechasEspeciales() {
        return fechasEspeciales;
    }

    public void setFechasEspeciales(List<Fecha_Especial> fechasEspeciales) {
        this.fechasEspeciales = fechasEspeciales;
    }

    public List<Reserva> getReservasFinca() {
        return reservasFinca;
    }

    public void setReservasFinca(List<Reserva> reservasFinca) {
        this.reservasFinca = reservasFinca;
    }
}