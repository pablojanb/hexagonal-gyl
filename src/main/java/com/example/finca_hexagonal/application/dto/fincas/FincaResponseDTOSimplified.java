package com.example.finca_hexagonal.application.dto.fincas;


import java.math.BigDecimal;

public class FincaResponseDTOSimplified {
    private Long id;
    private String nombre;
    private Long idUsuario;
    private String usuario;
    private Long idDireccion;
    private String direccion;
    private BigDecimal tarifaHora;

    public FincaResponseDTOSimplified() {
    }

    public FincaResponseDTOSimplified(Long id, String nombre, Long idUsuario, String usuario, Long idDireccion, String direccion, BigDecimal tarifaHora) {
        this.id = id;
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.idDireccion = idDireccion;
        this.direccion = direccion;
        this.tarifaHora = tarifaHora;
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
}
