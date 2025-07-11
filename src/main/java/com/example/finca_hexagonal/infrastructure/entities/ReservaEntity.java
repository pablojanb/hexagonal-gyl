
package com.example.finca_hexagonal.infrastructure.entities;

import com.example.finca_hexagonal.domain.models.enums.EstadoReserva;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "finca_id")
    private FincaEntity finca;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    private String diaSemana;
    private LocalDate fecha;
    private LocalTime desde;
    private LocalTime hasta;
    private BigDecimal total;
    private BigDecimal descuento;
    private BigDecimal recargo;
    private String detalle;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;

    public ReservaEntity() {}

    public ReservaEntity(Long id, FincaEntity finca, UsuarioEntity usuario, String diaSemana, LocalDate fecha, LocalTime desde, LocalTime hasta, BigDecimal total, BigDecimal descuento, BigDecimal recargo, String detalle, EstadoReserva estadoReserva) {
        this.id = id;
        this.finca = finca;
        this.usuario = usuario;
        this.diaSemana = diaSemana;
        this.fecha = fecha;
        this.desde = desde;
        this.hasta = hasta;
        this.total = total;
        this.descuento = descuento;
        this.recargo = recargo;
        this.detalle = detalle;
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

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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
