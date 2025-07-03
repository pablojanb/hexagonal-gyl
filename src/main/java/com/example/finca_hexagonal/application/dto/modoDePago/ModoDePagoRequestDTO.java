package com.example.finca_hexagonal.application.dto.modoDePago;

public  class ModoDePagoRequestDTO {
    private String nombre;

    public ModoDePagoRequestDTO() {
    }

    public ModoDePagoRequestDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}