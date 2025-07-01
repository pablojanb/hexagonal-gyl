package com.example.finca_hexagonal.application.dto.horarios;

import java.math.BigDecimal;
import java.time.LocalTime;


public class HorarioResponseDTO {
    private Long id;
    private Long idFinca;
    private String finca;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String diaSemana;
    private BigDecimal descuento;
    private BigDecimal recargo;

    public HorarioResponseDTO() {
    }

    public HorarioResponseDTO(Long id, Long idFinca, String finca, LocalTime horaInicio, LocalTime horaFin, String diaSemana, BigDecimal descuento, BigDecimal recargo) {
        this.id = id;
        this.idFinca = idFinca;
        this.finca = finca;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.diaSemana = diaSemana;
        this.descuento = descuento;
        this.recargo = recargo;
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

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
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
