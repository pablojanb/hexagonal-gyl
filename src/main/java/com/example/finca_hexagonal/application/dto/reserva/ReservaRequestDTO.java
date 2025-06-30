package com.example.finca_hexagonal.application.dto.reserva;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaRequestDTO {
    private Long idFinca;
    private Long idCliente;
    private LocalDate fecha;
    private LocalTime desde;
    private LocalTime hasta;
    private Boolean estadoReserva = false;

    public ReservaRequestDTO() {
    }

    public ReservaRequestDTO(Long idFinca, Long idCliente, LocalDate fecha, LocalTime desde, LocalTime hasta, Boolean estadoReserva) {
        this.idFinca = idFinca;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.desde = desde;
        this.hasta = hasta;
        this.estadoReserva = estadoReserva;
    }

    public Long getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Long idFinca) {
        this.idFinca = idFinca;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public Boolean getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(Boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}