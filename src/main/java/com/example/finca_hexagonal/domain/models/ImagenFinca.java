package com.example.finca_hexagonal.domain.models;

public class ImagenFinca {
    private Long id;
    private String url;
    private boolean esPortada;
    private Finca finca;

    public ImagenFinca() {
    }

    public ImagenFinca(Long id, String url, boolean esPortada, Finca finca) {
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

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }
}
