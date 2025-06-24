package com.example.finca_hexagonal.domain.models;

public class ImagenFinca {
    private Long idImagen;
    private String url;|
    private boolean esPortada;
    private Long fincaId;

    public ImagenFinca(Long idImagen, String url, boolean esPortada, Long fincaId) {
        this.idImagen = idImagen;
        this.url = url;
        this.esPortada = esPortada;
        this.fincaId = fincaId;
    }

    public Long getIdImagen() { return idImagen; }
    public void setIdImagen(Long idImagen) { this.idImagen = idImagen; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public boolean isEsPortada() { return esPortada; }
    public void setEsPortada(boolean esPortada) { this.esPortada = esPortada; }

    public Long getFincaId() { return fincaId; }
    public void setFincaId(Long fincaId) { this.fincaId = fincaId; }
}
