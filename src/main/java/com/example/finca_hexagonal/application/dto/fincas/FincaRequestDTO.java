package com.example.finca_hexagonal.application.dto.fincas;


import java.math.BigDecimal;

public class FincaRequestDTO {
    private String nombre;
    private Long idUsuario;
    private Long idDireccion;
    private BigDecimal tarifaHora;

    public FincaRequestDTO() {
    }

    public FincaRequestDTO(String nombre, Long idUsuario, Long idDireccion, BigDecimal tarifaHora) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.idDireccion = idDireccion;
        this.tarifaHora = tarifaHora;
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

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public BigDecimal getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(BigDecimal tarifaHora) {
        this.tarifaHora = tarifaHora;
    }
}
