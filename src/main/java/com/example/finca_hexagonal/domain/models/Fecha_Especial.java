package com.example.finca_hexagonal.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Fecha_Especial {
    private Long id;
    private LocalDateTime fecha;
    private LocalDateTime dia_semana;
    private LocalDateTime hora_inicio;
    private LocalDateTime hora_fin;
    private BigDecimal descuento;
    private BigDecimal recargo;
    private String motivo;
    private Finca finca;

    public Fecha_Especial() {
    }

    public Fecha_Especial(Long id, LocalDateTime fecha, LocalDateTime dia_semana, LocalDateTime hora_inicio, LocalDateTime hora_fin, BigDecimal descuento, BigDecimal recargo, String motivo, Finca finca) {
        this.id = id;
        this.fecha = fecha;
        this.dia_semana = dia_semana;
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

    public LocalDateTime getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(LocalDateTime dia_semana) {
        this.dia_semana = dia_semana;
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

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }
}
