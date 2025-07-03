package com.example.finca_hexagonal.application.dto.modoDePago;

public class ModoDePagoResponseDTO {
    private String nombre;

    public ModoDePagoResponseDTO(){

    }

    public ModoDePagoResponseDTO(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
