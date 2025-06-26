package com.example.finca_hexagonal.domain.models;

public class ModoDePago {
    private Long id;
    private Long pago_id;
    private String tipo;
    private String detalles;

    public ModoDePago(Long id, Long pago_id, String tipo, String detalles) {
        this.id = id;
        this.pago_id = pago_id;
        this.tipo = tipo;
        this.detalles = detalles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPago_id() {
        return pago_id;
    }

    public void setPago_id(Long pago_id) {
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