package com.example.finca_hexagonal.application.dto.fincas;

import com.example.finca_hexagonal.domain.models.Fecha_Especial;
import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.models.Reserva;


import java.math.BigDecimal;
import java.util.List;


public class FincaResponseDTO {
    private Long id;
    private String nombre;
    private Long id_propietario;
    private String propietario;
    private Long id_direccion;
    private String direccion;
    private BigDecimal tarifa_hora;
    private Long id_detalle;

    private List<Horario> horarios;
    private List<ImagenFinca> imagenesFinca;
    private List<Fecha_Especial> fechasEspeciales;
    private List<Reserva> reservasFinca;

    public FincaResponseDTO() {
    }

    public FincaResponseDTO(Long id, String nombre, Long id_propietario, String propietario, Long id_direccion, String direccion, BigDecimal tarifa_hora, Long id_detalle, List<Horario> horarios, List<ImagenFinca> imagenesFinca, List<Fecha_Especial> fechasEspeciales, List<Reserva> reservasFinca) {
        this.id = id;
        this.nombre = nombre;
        this.id_propietario = id_propietario;
        this.propietario = propietario;
        this.id_direccion = id_direccion;
        this.direccion = direccion;
        this.tarifa_hora = tarifa_hora;
        this.id_detalle = id_detalle;
        this.horarios = horarios;
        this.imagenesFinca = imagenesFinca;
        this.fechasEspeciales = fechasEspeciales;
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

    public Long getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(Long id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getTarifa_hora() {
        return tarifa_hora;
    }

    public void setTarifa_hora(BigDecimal tarifa_hora) {
        this.tarifa_hora = tarifa_hora;
    }

    public Long getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(Long id_detalle) {
        this.id_detalle = id_detalle;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<ImagenFinca> getImagenesFinca() {
        return imagenesFinca;
    }

    public void setImagenesFinca(List<ImagenFinca> imagenesFinca) {
        this.imagenesFinca = imagenesFinca;
    }

    public List<Fecha_Especial> getFechasEspeciales() {
        return fechasEspeciales;
    }

    public void setFechasEspeciales(List<Fecha_Especial> fechasEspeciales) {
        this.fechasEspeciales = fechasEspeciales;
    }

    public List<Reserva> getReservasFinca() {
        return reservasFinca;
    }

    public void setReservasFinca(List<Reserva> reservasFinca) {
        this.reservasFinca = reservasFinca;
    }
}
