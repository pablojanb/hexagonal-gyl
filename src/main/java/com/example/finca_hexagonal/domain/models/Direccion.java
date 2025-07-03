package com.example.finca_hexagonal.domain.models;


public class Direccion {
    private Long id;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String aclaracion;

    public Direccion() {
    }

    public Direccion(Long id, String direccion, String ciudad, String provincia, String aclaracion) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.aclaracion = aclaracion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getAclaracion() {
        return aclaracion;
    }

    public void setAclaracion(String aclaracion) {
        this.aclaracion = aclaracion;
    }
}


