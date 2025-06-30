package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;

@Entity
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "finca_id")
    private FincaEntity finca;
    @Temporal(TemporalType.TIME)
    private Time hora_inicio;
    @Temporal(TemporalType.TIME)
    private Time hora_fin;
    private String dia_Semana;
    private BigDecimal descuento;
    private BigDecimal recargo;

    public HorarioEntity() {
    }

    public HorarioEntity(Long id, FincaEntity finca, Time hora_inicio, Time hora_fin, String dia_Semana, BigDecimal descuento, BigDecimal recargo) {
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

    public FincaEntity getFinca() {
        return finca;
    }

    public void setFinca(FincaEntity finca) {
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
