package com.example.finca_hexagonal.application.dto.horarios;

import java.math.BigDecimal;
import java.sql.Time;

public class HorarioResponseDTO {
    private Long id;
    private Long id_finca;
    private String finca;
    private Time hora_inicio;
    private Time hora_fin;
    private String dia_Semana;
    private BigDecimal descuento;
    private BigDecimal recargo;

    public HorarioResponseDTO() {
    }

    public HorarioResponseDTO(Long id, Long id_finca, String finca, Time hora_inicio, Time hora_fin, String dia_Semana, BigDecimal descuento, BigDecimal recargo) {
        this.id = id;
        this.id_finca = id_finca;
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

    public Long getId_finca() {
        return id_finca;
    }

    public void setId_finca(Long id_finca) {
        this.id_finca = id_finca;
    }

    public String getFinca() {
        return finca;
    }

    public void setFinca(String finca) {
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
