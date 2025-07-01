package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fincaId")
    private FincaEntity finca;
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuario;
    private LocalDate fecha;
    private LocalTime desde;
    private LocalTime hasta;
    private BigDecimal total;
    private Boolean estadoReserva;

    public ReservaEntity() {
    }

    public ReservaEntity(Long id, FincaEntity finca, UsuarioEntity usuario, LocalDate fecha, LocalTime desde, LocalTime hasta, BigDecimal total, Boolean estadoReserva) {
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

    public FincaEntity getFinca() {
        return finca;
    }

    public void setFinca(FincaEntity finca) {
        this.finca = finca;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
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