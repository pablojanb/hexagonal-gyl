package com.example.finca_hexagonal.domain.models;

import com.example.finca_hexagonal.domain.models.enums.EstadoPago;
import com.example.finca_hexagonal.domain.models.enums.MedioPago;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pago {
    private  Long id;
    private Reserva reserva;
    private LocalDateTime fechaPago;
    private BigDecimal monto;
    private BigDecimal descuentoAplicado;
    private BigDecimal recargoAplicado;
    private EstadoPago estadoPago;
    private BigDecimal montoTotal;
    private MedioPago medioPago;
    private List<String> detalles;

    public Pago(){
        this.fechaPago =  LocalDateTime.now();
        this.estadoPago = EstadoPago.PENDIENTE;
        this.recargoAplicado = new BigDecimal("0");
        this.descuentoAplicado = new BigDecimal("0");
        this.detalles = new ArrayList<>();
        this.getDetalles().add("Pendiente de pago");
    };



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
    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }
}
