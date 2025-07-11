package com.example.finca_hexagonal.domain.models;

import com.example.finca_hexagonal.domain.models.enums.EstadoPago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pago {
    private  Long id;
    private Reserva reserva;
    private LocalDateTime fechaPago;
    private BigDecimal monto;
    private BigDecimal descuentoAplicado;
    private BigDecimal recargoAplicado;
    private EstadoPago estadoPago;
    private BigDecimal montoTotal;
    private ModoDePago modoDePago;

    public Pago(){
        this.fechaPago =  LocalDateTime.now();
        this.estadoPago = EstadoPago.PENDING;
    };

    public Pago(Long id, Reserva reserva, LocalDateTime fechaHora, BigDecimal monto, BigDecimal descuentoAplicado, BigDecimal recargoAplicado, EstadoPago estadoPago, BigDecimal montoTotal, ModoDePago modoDePago) {
        this.id = id;
        this.reserva = reserva;
        this.fechaPago = fechaHora;
        this.monto = monto;
        this.descuentoAplicado = descuentoAplicado;
        this.recargoAplicado = recargoAplicado;
        this.estadoPago = estadoPago;
        this.montoTotal = montoTotal;
        this.modoDePago = modoDePago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public ModoDePago getModoDePago() {
        return modoDePago;
    }

    public void setModoDePago(ModoDePago modoDePago) {
        this.modoDePago = modoDePago;
    }


}
