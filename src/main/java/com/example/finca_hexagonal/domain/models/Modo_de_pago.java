package com.example.finca_hexagonal.domain.models;

public class Modo_de_pago {
    private Integer id;
    private Integer pago_id;
    private String tipo;
    private String detalles;

    public Modo_de_pago(Integer id, Integer pago_id, String tipo, String detalles) {
        this.id = id;
        this.pago_id = pago_id;
        this.tipo = tipo;
        this.detalles = detalles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPago_id() {
        return pago_id;
    }

    public void setPago_id(Integer pago_id) {
        this.pago_id = pago_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}