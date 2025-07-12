package com.example.finca_hexagonal.application.dto.pago;

import com.example.finca_hexagonal.domain.models.enums.EstadoPago;
import com.example.finca_hexagonal.domain.models.enums.MedioPago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponseDTO {
    private  Long id;
    private Long idReserva;
    private EstadoPago estadoPago;
    private MedioPago medioPago;
    private String linkPago;
    private LocalDateTime fechaPago;
    private BigDecimal monto;
    private BigDecimal montoTotalConImpuestos;
    private BigDecimal descuentoAplicado;
    private BigDecimal recargoAplicado;

    public  PagoResponseDTO(){};



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
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

    public BigDecimal getMontoTotalConImpuestos() {
        return montoTotalConImpuestos;
    }

    public void setMontoTotalConImpuestos(BigDecimal montoTotalConImpuestos) {
        this.montoTotalConImpuestos = montoTotalConImpuestos;
    }

    public String getLinkPago() {
        return linkPago;
    }

    public void setLinkPago(String linkPago) {
        this.linkPago = linkPago;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }
}
