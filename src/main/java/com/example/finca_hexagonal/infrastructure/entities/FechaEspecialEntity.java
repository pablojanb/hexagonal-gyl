package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fechas_especiales")
public class FechaEspecialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    @Column(name = "dia_semana")
    private LocalDateTime diaSemana;
    private LocalDateTime hora_inicio;
    private LocalDateTime hora_fin;
    private BigDecimal descuento;
    private BigDecimal recargo;
    private String motivo;
    @ManyToOne
    @JoinColumn(name = "finca_id")
    private FincaEntity finca;

    public FechaEspecialEntity() {
    }

    public FechaEspecialEntity(Long id, LocalDateTime fecha, LocalDateTime diaSemana, LocalDateTime hora_inicio, LocalDateTime hora_fin, BigDecimal descuento, BigDecimal recargo, String motivo, FincaEntity finca) {
        this.id = id;
        this.fecha = fecha;
        this.diaSemana = diaSemana;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.descuento = descuento;
        this.recargo = recargo;
        this.motivo = motivo;
        this.finca = finca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getDiaSemana() {

        return diaSemana;
    }

    public void setDiasemana(LocalDateTime diaSemana) {

        this.diaSemana = diaSemana;
    }

    public LocalDateTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalDateTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalDateTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalDateTime hora_fin) {
        this.hora_fin = hora_fin;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public FincaEntity getFinca() {
        return finca;
    }

    public void setFinca(FincaEntity finca) {
        this.finca = finca;
    }
}
