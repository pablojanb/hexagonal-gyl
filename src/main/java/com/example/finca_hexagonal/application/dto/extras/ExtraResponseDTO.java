package com.example.finca_hexagonal.application.dto.extras;

public class ExtraResponseDTO {
    private Long id;
    private String nombre;

    public ExtraResponseDTO() {
    }

    public ExtraResponseDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
