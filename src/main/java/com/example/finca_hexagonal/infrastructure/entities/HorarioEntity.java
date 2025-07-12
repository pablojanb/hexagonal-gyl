package com.example.finca_hexagonal.infrastructure.entities;

import com.example.finca_hexagonal.domain.models.enums.DiaDeSemana;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "horarios")
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fincaId")
    private FincaEntity finca;
    @Temporal(TemporalType.TIME)
    private LocalTime horaInicio;
    @Temporal(TemporalType.TIME)
    private LocalTime horaFin;
    @Enumerated(EnumType.STRING)
    private DiaDeSemana diaSemana;
    private BigDecimal descuento;
    private BigDecimal recargo;

    public HorarioEntity() {
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
