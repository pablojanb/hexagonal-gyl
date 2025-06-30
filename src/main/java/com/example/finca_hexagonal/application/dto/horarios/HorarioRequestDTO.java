package com.example.finca_hexagonal.application.dto.horarios;

import java.math.BigDecimal;
import java.sql.Time;

public class HorarioRequestDTO {
    private Long id_finca;
    private Time hora_inicio;
    private Time hora_fin;
    private String dia_Semana;
    private BigDecimal descuento;
    private BigDecimal recargo;

    public HorarioRequestDTO() {
    }

    public HorarioRequestDTO(Long id_finca, Time hora_inicio, Time hora_fin, String dia_Semana, BigDecimal descuento, BigDecimal recargo) {
        this.id_finca = id_finca;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.dia_Semana = dia_Semana;
        this.descuento = descuento;
        this.recargo = recargo;
    }

    public Long getId_finca() {
        return id_finca;
    }

    public void setId_finca(Long id_finca) {
        this.id_finca = id_finca;
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
