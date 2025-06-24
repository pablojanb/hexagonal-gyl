package com.example.finca_hexagonal.domain.models;

import java.math.BigDecimal;

public class ComprobantePago {
    private Integer id;
    private Integer pago_id;
    private BigDecimal monto;
    private Integer modo_de_pago_id;
    private String descripcion;

    public ComprobantePago(Integer id, Integer pago_id, BigDecimal monto, Integer modo_de_pago_id, String descripcion) {
        this.id = id;
        this.pago_id = pago_id;
        this.monto = monto;
        this.modo_de_pago_id = modo_de_pago_id;
        this.descripcion = descripcion;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Integer getModo_de_pago_id() {
        return modo_de_pago_id;
    }

    public void setModo_de_pago_id(Integer modo_de_pago_id) {
        this.modo_de_pago_id = modo_de_pago_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
