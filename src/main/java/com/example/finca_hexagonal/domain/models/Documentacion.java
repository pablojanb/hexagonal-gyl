package com.example.finca_hexagonal.domain.models;

public class Documentacion {
    private Long id;
    private Finca finca;
    private String escrituraPropiedad;
    private String planoCatastral;
    private String impuestoBienesInmuebles;

    public Documentacion() {
    }

    public Documentacion(Long id, Finca finca, String escrituraPropiedad, String planoCatastral, String impuestoBienesInmuebles) {
        this.id = id;
        this.finca = finca;
        this.escrituraPropiedad = escrituraPropiedad;
        this.planoCatastral = planoCatastral;
        this.impuestoBienesInmuebles = impuestoBienesInmuebles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }

    public String getEscrituraPropiedad() {
        return escrituraPropiedad;
    }

    public void setEscrituraPropiedad(String escrituraPropiedad) {
        this.escrituraPropiedad = escrituraPropiedad;
    }

    public String getPlanoCatastral() {
        return planoCatastral;
    }

    public void setPlanoCatastral(String planoCatastral) {
        this.planoCatastral = planoCatastral;
    }

    public String getImpuestoBienesInmuebles() {
        return impuestoBienesInmuebles;
    }

    public void setImpuestoBienesInmuebles(String impuestoBienesInmuebles) {
        this.impuestoBienesInmuebles = impuestoBienesInmuebles;
    }
}
