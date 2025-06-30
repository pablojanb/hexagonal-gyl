package com.example.finca_hexagonal.application.dto.fincas;

import java.math.BigDecimal;

public class FincaResponseDTOSimplified {
    private Long id;
    private String nombre;
    private Long idPropietario;
    private String propietario;
    private Long idDireccion;
    private String direccion;
    private BigDecimal tarifaHora;
    private Long idDetalle;

    public FincaResponseDTOSimplified() {
    }

    public FincaResponseDTOSimplified(Long id, String nombre, Long idPropietario, String propietario, Long idDireccion, String direccion, BigDecimal tarifaHora, Long idDetalle) {
        this.id = id;
        this.nombre = nombre;
        this.idPropietario = idPropietario;
        this.propietario = propietario;
        this.idDireccion = idDireccion;
        this.direccion = direccion;
        this.tarifaHora = tarifaHora;
        this.idDetalle = idDetalle;
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

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
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

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }
}
