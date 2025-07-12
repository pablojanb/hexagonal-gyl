package com.example.finca_hexagonal.domain.models;

import com.example.finca_hexagonal.domain.models.enums.DiaDeSemana;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Horario {
    private Long id;
    private Finca finca;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private DiaDeSemana diaSemana;
    private BigDecimal descuento;
    private BigDecimal recargo;

    public Horario() {
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

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public DiaDeSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaDeSemana diaSemana) {
        this.diaSemana = diaSemana;
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
