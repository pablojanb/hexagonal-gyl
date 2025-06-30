package com.example.finca_hexagonal.domain.models;

import java.math.BigDecimal;
import java.sql.Time;

public class Horario {
    private Long id;
    private Finca finca;
    private Time hora_inicio;
    private Time hora_fin;
    private String dia_Semana;
    private BigDecimal descuento;
    private BigDecimal recargo;

    public Horario() {
    }

    public Horario(Long id, Finca finca, Time hora_inicio, Time hora_fin, String dia_Semana, BigDecimal descuento, BigDecimal recargo) {
        this.id = id;
        this.finca = finca;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.dia_Semana = dia_Semana;
        this.descuento = descuento;
        this.recargo = recargo;
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

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getDia_Semana() {
        return dia_Semana;
    }

    public void setDia_Semana(String dia_Semana) {
        this.dia_Semana = dia_Semana;
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
}
