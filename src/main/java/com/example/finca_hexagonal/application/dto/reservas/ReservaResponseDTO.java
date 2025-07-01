package com.example.finca_hexagonal.application.dto.reservas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaResponseDTO {
    private Long id;
    private Long idFinca;
    private String finca;
    private Long idUsuario;
    private String usuario;
    private LocalDate fecha;
    private LocalTime desde;
    private LocalTime hasta;
    private BigDecimal total;
    private Boolean estadoReserva;

    public ReservaResponseDTO() {
    }

    public ReservaResponseDTO(Long id, Long idFinca, String finca, Long idUsuario, String usuario, LocalDate fecha, LocalTime desde, LocalTime hasta, BigDecimal total, Boolean estadoReserva) {
        this.id = id;
        this.idFinca = idFinca;
        this.finca = finca;
        this.idUsuario = idUsuario;
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

    public Long getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Long idFinca) {
        this.idFinca = idFinca;
    }

    public String getFinca() {
        return finca;
    }

    public void setFinca(String finca) {
        this.finca = finca;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
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

    public Boolean getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(Boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
