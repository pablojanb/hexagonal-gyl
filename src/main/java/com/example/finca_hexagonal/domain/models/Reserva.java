package com.example.finca_hexagonal.domain.models;

import com.example.finca_hexagonal.domain.models.enums.DiaDeSemana;
import com.example.finca_hexagonal.domain.models.enums.EstadoReserva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private Long id;
    private Finca finca;
    private Usuario usuario;
    private LocalDate fecha;
    private LocalTime desde;
    private LocalTime hasta;
    private BigDecimal total;
    private BigDecimal descuento;
    private BigDecimal recargo;
    private String detalle;
    private EstadoReserva estadoReserva;


    public Reserva(){
        this.setEstadoReserva(EstadoReserva.PENDING);
        this.descuento = new BigDecimal("0");
        this.recargo = new BigDecimal("0");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getDesde() {
        return desde;
    }

    public void setDesde(LocalTime desde) {
        this.desde = desde;
    }

    public LocalTime getHasta() {
        return hasta;
    }

    public void setHasta(LocalTime hasta) {
        this.hasta = hasta;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getRecargo() {
        return recargo;
    }

    public void setRecargo(BigDecimal recargo) {
        this.recargo = recargo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
}

}