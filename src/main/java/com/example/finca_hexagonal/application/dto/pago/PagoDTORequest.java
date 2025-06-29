package com.example.finca_hexagonal.application.dto.pago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoDTORequest {

    private Integer id;
    private Integer reserva_id;
    private BigDecimal monto_total;
    private Integer modo_pago_id;
    private LocalDateTime fecha_hora;
    private BigDecimal desucento_aplicado;
    private BigDecimal recargo_aplicado;
    private Boolean estado_pago;

    public PagoDTORequest(){};

    public PagoDTORequest(Integer id, Integer reserva_id, BigDecimal monto_total, Integer modo_pago_id, LocalDateTime fecha_hora, BigDecimal desucento_aplicado, BigDecimal recargo_aplicado, Boolean estado_pago) {
        this.id = id;
        this.reserva_id = reserva_id;
        this.monto_total = monto_total;
        this.modo_pago_id = modo_pago_id;
        this.fecha_hora = fecha_hora;
        this.desucento_aplicado = desucento_aplicado;
        this.recargo_aplicado = recargo_aplicado;
        this.estado_pago = estado_pago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(Integer reserva_id) {
        this.reserva_id = reserva_id;
    }

    public BigDecimal getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(BigDecimal monto_total) {
        this.monto_total = monto_total;
    }

    public Integer getModo_pago_id() {
        return modo_pago_id;
    }

    public void setModo_pago_id(Integer modo_pago_id) {
        this.modo_pago_id = modo_pago_id;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public BigDecimal getDesucento_aplicado() {
        return desucento_aplicado;
    }

    public void setDesucento_aplicado(BigDecimal desucento_aplicado) {
        this.desucento_aplicado = desucento_aplicado;
    }

    public BigDecimal getRecargo_aplicado() {
        return recargo_aplicado;
    }

    public void setRecargo_aplicado(BigDecimal recargo_aplicado) {
        this.recargo_aplicado = recargo_aplicado;
    }

    public Boolean getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(Boolean estado_pago) {
        this.estado_pago = estado_pago;
    }
}
