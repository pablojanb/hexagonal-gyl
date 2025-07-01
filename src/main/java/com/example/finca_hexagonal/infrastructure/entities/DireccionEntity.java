package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class DireccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private int altura;
    private String ciudad;
    private String provincia;
    private String aclaracion;

    public DireccionEntity() {
    }

    public DireccionEntity(Long id, String calle, int altura, String ciudad, String provincia, String aclaracion) {
        this.id = id;
        this.calle = calle;
        this.altura = altura;
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
