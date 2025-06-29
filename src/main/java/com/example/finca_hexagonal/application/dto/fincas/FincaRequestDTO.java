package com.example.finca_hexagonal.application.dto.fincas;


import java.math.BigDecimal;

public class FincaRequestDTO {
    private String nombre;
    private Long idPropietario;
    private Long idDetalleFinca;
    private Long idDireccion;
    private BigDecimal tarifaHora;

    public FincaRequestDTO() {
    }

    public FincaRequestDTO(String nombre, Long idPropietario, Long idDetalleFinca, Long idDireccion, BigDecimal tarifaHora) {
        this.nombre = nombre;
        this.idPropietario = idPropietario;
        this.idDetalleFinca = idDetalleFinca;
        this.idDireccion = idDireccion;
        this.tarifaHora = tarifaHora;
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

    public Long getIdDetalleFinca() {
        return idDetalleFinca;
    }

    public void setIdDetalleFinca(Long idDetalleFinca) {
        this.idDetalleFinca = idDetalleFinca;
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
