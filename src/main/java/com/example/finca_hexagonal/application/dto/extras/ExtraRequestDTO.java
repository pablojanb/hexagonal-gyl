package com.example.finca_hexagonal.application.dto.extras;

public class ExtraRequestDTO {
    private String nombre;

    public ExtraRequestDTO() {
    }

    public ExtraRequestDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
