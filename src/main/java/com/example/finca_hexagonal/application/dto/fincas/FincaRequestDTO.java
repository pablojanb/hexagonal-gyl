package com.example.finca_hexagonal.application.dto.fincas;


import java.math.BigDecimal;

public class FincaRequestDTO {
    private String nombre;
    private Long id_propietario;
    private Long id_detalleFinca;
    private Long id_direccion;
    private BigDecimal tarifa_hora;

    public FincaRequestDTO() {
    }

    public FincaRequestDTO(String nombre, Long id_propietario, Long id_detalleFinca, Long id_direccion, BigDecimal tarifa_hora) {
        this.nombre = nombre;
        this.id_propietario = id_propietario;
        this.id_detalleFinca = id_detalleFinca;
        this.id_direccion = id_direccion;
        this.tarifa_hora = tarifa_hora;
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

    public Long getId_detalleFinca() {
        return id_detalleFinca;
    }

    public void setId_detalleFinca(Long id_detalleFinca) {
        this.id_detalleFinca = id_detalleFinca;
    }

    public Long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public BigDecimal getTarifa_hora() {
        return tarifa_hora;
    }

    public void setTarifa_hora(BigDecimal tarifa_hora) {
        this.tarifa_hora = tarifa_hora;
    }
}
