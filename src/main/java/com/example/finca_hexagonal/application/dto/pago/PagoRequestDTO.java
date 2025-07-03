package com.example.finca_hexagonal.application.dto.pago;

import com.example.finca_hexagonal.domain.models.enums.EstadoPago;

import java.math.BigDecimal;

public class PagoRequestDTO {

    private Long reservaId;

    private Long medioDePagoId;

    private BigDecimal monto;

    private BigDecimal descuentoAplicado;

    private BigDecimal recargoAplicado;

    private EstadoPago estadoPago = EstadoPago.PENDING;

    public PagoRequestDTO() {
    }

    public PagoRequestDTO(Long reservaId, Long medioDePagoId, BigDecimal monto, BigDecimal descuentoAplicado, BigDecimal recargoAplicado, EstadoPago estadoPago) {
        this.reservaId = reservaId;
        this.medioDePagoId = medioDePagoId;
        this.monto = monto;
        this.descuentoAplicado = descuentoAplicado;
        this.recargoAplicado = recargoAplicado;
        this.estadoPago = estadoPago;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public Long getMedioDePagoId() {
        return medioDePagoId;
    }

    public void setMedioDePagoId(Long medioDePagoId) {
        this.medioDePagoId = medioDePagoId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(BigDecimal descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public BigDecimal getRecargoAplicado() {
        return recargoAplicado;
    }

    public void setRecargoAplicado(BigDecimal recargoAplicado) {
        this.recargoAplicado = recargoAplicado;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }
}