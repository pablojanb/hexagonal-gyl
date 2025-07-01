package com.example.finca_hexagonal.application.dto.fincas;

import com.example.finca_hexagonal.domain.models.*;

import java.math.BigDecimal;
import java.util.List;

public class FincaResponseDTO {
    private Long id;
    private String nombre;
    private Long idUsuario;
    private String usuario;
    private Long idDireccion;
    private String direccion;
    private BigDecimal tarifaHora;

    private List<DetalleFinca> detalles;
    private List<Horario> horarios;
    private List<ImagenFinca> imagenesFinca;
    private List<Fecha_Especial> fechasEspeciales;
    private List<Reserva> reservasFinca;

    public FincaResponseDTO() {
    }

    public FincaResponseDTO(Long id, String nombre, Long idUsuario, String usuario, Long idDireccion, String direccion, BigDecimal tarifaHora, List<DetalleFinca> detalles, List<Horario> horarios, List<ImagenFinca> imagenesFinca, List<Fecha_Especial> fechasEspeciales, List<Reserva> reservasFinca) {
        this.id = id;
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.idDireccion = idDireccion;
        this.direccion = direccion;
        this.tarifaHora = tarifaHora;
        this.detalles = detalles;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(BigDecimal tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public List<DetalleFinca> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFinca> detalles) {
        this.detalles = detalles;
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
