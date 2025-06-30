package com.example.finca_hexagonal.infrastructure.entities;

import com.example.finca_hexagonal.domain.models.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class FincaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    @OneToOne
    private PropietarioEntity propietario;
    @OneToOne
    private DetalleFincaEntity detalle;
    @OneToOne
    private DireccionEntity direccion;

    private BigDecimal tarifa_hora;

    @OneToMany
    private List<HorarioEntity> horarios;

    @OneToMany
    private List<ImagenFincaEntity> imagenesFinca;

    @OneToMany
    private List<FechaEspecialEntity> fechasEspFinca;

    @OneToMany(mappedBy = "finca")
    private List<ReservaEntity> reservasFinca;

    public FincaEntity() {
    }

    public FincaEntity(Long id, String nombre, PropietarioEntity propietario, DetalleFincaEntity detalle, DireccionEntity direccion, BigDecimal tarifa_hora, List<HorarioEntity> horarios, List<ImagenFincaEntity> imagenesFinca, List<FechaEspecialEntity> fechasEspFinca, List<ReservaEntity> reservasFinca) {
        this.id = id;
        this.nombre = nombre;
        this.propietario = propietario;
        this.detalle = detalle;
        this.direccion = direccion;
        this.tarifa_hora = tarifa_hora;
        this.horarios = horarios;
        this.imagenesFinca = imagenesFinca;
        this.fechasEspFinca = fechasEspFinca;
        this.reservasFinca = reservasFinca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PropietarioEntity getPropietario() {
        return propietario;
    }

    public void setPropietario(PropietarioEntity propietario) {
        this.propietario = propietario;
    }

    public DetalleFincaEntity getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleFincaEntity detalle) {
        this.detalle = detalle;
    }

    public DireccionEntity getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionEntity direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getTarifa_hora() {
        return tarifa_hora;
    }

    public void setTarifa_hora(BigDecimal tarifa_hora) {
        this.tarifa_hora = tarifa_hora;
    }

    public List<HorarioEntity> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntity> horarios) {
        this.horarios = horarios;
    }

    public List<ImagenFincaEntity> getImagenesFinca() {
        return imagenesFinca;
    }

    public void setImagenesFinca(List<ImagenFincaEntity> imagenesFinca) {
        this.imagenesFinca = imagenesFinca;
    }

    public List<FechaEspecialEntity> getFechasEspFinca() {
        return fechasEspFinca;
    }

    public void setFechasEspFinca(List<FechaEspecialEntity> fechasEspFinca) {
        this.fechasEspFinca = fechasEspFinca;
    }

    public List<ReservaEntity> getReservasFinca() {
        return reservasFinca;
    }

    public void setReservasFinca(List<ReservaEntity> reservasFinca) {
        this.reservasFinca = reservasFinca;
    }
}
