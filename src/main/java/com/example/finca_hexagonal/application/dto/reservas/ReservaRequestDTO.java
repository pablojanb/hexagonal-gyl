package com.example.finca_hexagonal.application.dto.reservas;

import com.example.finca_hexagonal.domain.models.enums.EstadoReserva;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaRequestDTO {
    private Long idFinca;
    private Long idUsuario;
    private LocalDate fecha;
    private LocalTime desde;
    private LocalTime hasta;
    private EstadoReserva estadoReserva = EstadoReserva.PENDING;

    public ReservaRequestDTO() {}

    public ReservaRequestDTO(Long idFinca, Long idUsuario, LocalDate fecha, LocalTime desde, LocalTime hasta, EstadoReserva estadoReserva) {
        this.idFinca = idFinca;
        this.idUsuario = idUsuario;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
