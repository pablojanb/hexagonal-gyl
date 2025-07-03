package com.example.finca_hexagonal.application.dto.fechaEspecial;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FechaEspecialRequestDTO {
    private Long idFinca;
    private LocalDateTime fecha;
    private String dia_semana;
    private LocalDateTime hora_inicio;
    private LocalDateTime hora_fin;
    private BigDecimal descuento;
    private BigDecimal recargo;
    private String motivo;

    public FechaEspecialRequestDTO() {
    }

    public FechaEspecialRequestDTO(Long idFinca, LocalDateTime fecha,String dia_semana, LocalDateTime hora_inicio, LocalDateTime hora_fin, BigDecimal descuento, BigDecimal recargo, String motivo) {
        this.idFinca = idFinca;
        this.fecha = fecha;
        this.dia_semana = dia_semana;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.descuento = descuento;
        this.recargo = recargo;
        this.motivo = motivo;
    }

    public Long getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Long idFinca) {
        this.idFinca = idFinca;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
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
}
