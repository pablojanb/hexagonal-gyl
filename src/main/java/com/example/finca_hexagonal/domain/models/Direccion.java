package com.example.finca_hexagonal.domain.models;


public class Direccion {
    private Long id;
    private String calle;
    private int altura;
    private String ciudad;
    private String provincia;
    private String aclaracion;

    public Direccion(Long id_direccion, String calle, String ciudad, int altura, String provincia, String aclaracion) {
        this.id = id_direccion;
        this.calle = calle;
        this.ciudad = ciudad;
        this.altura = altura;
        this.provincia = provincia;
        this.aclaracion = aclaracion;
    }

    public Direccion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
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


