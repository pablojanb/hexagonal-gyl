package com.example.finca_hexagonal.domain.models;

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
    private EstadoReserva estadoReserva;


    public Reserva(){

    }

    public Reserva(Long id, Finca finca, Usuario usuario, LocalDate fecha, LocalTime desde, LocalTime hasta, BigDecimal total, EstadoReserva estadoReserva) {
        this.id = id;
        this.finca = finca;
        this.usuario = usuario;
        this.fecha = fecha;
        this.desde = desde;
        this.hasta = hasta;
        this.total = total;
        this.estadoReserva = estadoReserva;
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

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
}


    public void calcularTotalReserva() {
        if (finca != null && finca.getTarifaHora() != null && desde != null && hasta != null) {
            long horas = java.time.Duration.between(desde, hasta).toHours();
            if (horas < 1) horas = 1;
            this.total = finca.getTarifaHora().multiply(BigDecimal.valueOf(horas));
        } else {
            this.total = BigDecimal.ZERO;
        }
    }

}