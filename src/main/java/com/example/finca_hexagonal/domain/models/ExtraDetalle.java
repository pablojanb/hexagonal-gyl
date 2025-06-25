package com.example.finca_hexagonal.domain.models;

public class ExtraDetalle {
    private Long extra_id;
    private Long detalle_id;

    public ExtraDetalle() {}

    public Long getExtra_id() {
        return extra_id;
    }

    public void setExtra_id(Long extra_id) {
        this.extra_id = extra_id;
    }

    public Long getDetalle_id() {
        return detalle_id;
    }

    public void setDetalle_id(Long detalle_id) {
        this.detalle_id = detalle_id;
    }
}
