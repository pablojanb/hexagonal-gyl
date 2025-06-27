package com.example.finca_hexagonal.application.dto.fincas;


import java.math.BigDecimal;

public class FincaResponseDTOSimplified {
    private Long id;
    private String nombre;
    private Long id_propietario;
    private String propietario;
    private Long id_direccion;
    private String direccion;
    private BigDecimal tarifa_hora;
    private Long id_detalle;

    public FincaResponseDTOSimplified() {
    }

    public FincaResponseDTOSimplified(Long id, String nombre, Long id_propietario, String propietario, Long id_direccion, String direccion, BigDecimal tarifa_hora, Long id_detalle) {
        this.id = id;
        this.nombre = nombre;
        this.id_propietario = id_propietario;
        this.propietario = propietario;
        this.id_direccion = id_direccion;
        this.direccion = direccion;
        this.tarifa_hora = tarifa_hora;
        this.id_detalle = id_detalle;
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
}
