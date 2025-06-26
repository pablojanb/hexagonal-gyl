package com.example.finca_hexagonal.domain.models;

import java.math.BigDecimal;
import java.util.List;

public class Finca {
    private Long id;
    private String nombre;
    private Propietario propietario;
    private DetalleFinca detalle;
    private Direccion direccion;
    private BigDecimal tarifa_hora;

    private List<Horario> horarios;
    private List<ImagenFinca> imagenesFinca;
    private List<Fecha_Especial> fechasEspeciales;
    private List<Reserva> reservasFinca;


    public Finca() {
    }

    public Finca(Long id, String nombre, Propietario propietario, DetalleFinca detalle, Direccion direccion, BigDecimal tarifa_hora, List<Horario> horarios, List<ImagenFinca> imagenesFinca, List<Fecha_Especial> fechasEspeciales, List<Reserva> reservasFinca) {
        this.id = id;
        this.nombre = nombre;
        this.propietario = propietario;
        this.detalle = detalle;
        this.direccion = direccion;
        this.tarifa_hora = tarifa_hora;
        this.horarios = horarios;
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

    public BigDecimal getTarifa_hora() {
        return tarifa_hora;
    }

    public void setTarifa_hora(BigDecimal tarifa_hora) {
        this.tarifa_hora = tarifa_hora;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
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