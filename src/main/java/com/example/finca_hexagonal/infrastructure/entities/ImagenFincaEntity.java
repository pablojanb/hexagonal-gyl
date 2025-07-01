package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenes")
public class ImagenFincaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private boolean esPortada;

    @ManyToOne
    @JoinColumn(name = "id_finca")
    private FincaEntity finca;

    public ImagenFincaEntity() {
    }

    public ImagenFincaEntity(Long id, String url, boolean esPortada, FincaEntity finca) {
        this.id = id;
        this.url = url;
        this.esPortada = esPortada;
        this.finca = finca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEsPortada() {
        return esPortada;
    }

    public void setEsPortada(boolean esPortada) {
        this.esPortada = esPortada;
    }

    public FincaEntity getFinca() {
        return finca;
    }

    public void setFinca(FincaEntity finca) {
        this.finca = finca;
    }
}
