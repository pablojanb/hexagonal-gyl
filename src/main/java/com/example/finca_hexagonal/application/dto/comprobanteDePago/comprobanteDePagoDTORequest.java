package com.example.finca_hexagonal.application.dto.comprobanteDePago;

import java.math.BigDecimal;

public class comprobanteDePagoDTORequest {
    private Long id;
    private Long pago_id;
    private BigDecimal monto;
    private Long modo_de_pago_id;
    private String descripcion;

    public comprobanteDePagoDTORequest(){};



    public comprobanteDePagoDTORequest(Long id, Long pago_id, BigDecimal monto, Long modo_de_pago_id, String descripcion) {
        this.id = id;
        this.pago_id = pago_id;
        this.monto = monto;
        this.modo_de_pago_id = modo_de_pago_id;
        this.descripcion = descripcion;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Long getModo_de_pago_id() {
        return modo_de_pago_id;
    }

    public void setModo_de_pago_id(Long modo_de_pago_id) {
        this.modo_de_pago_id = modo_de_pago_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
