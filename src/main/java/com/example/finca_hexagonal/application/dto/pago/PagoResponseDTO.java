package com.example.finca_hexagonal.application.dto.pago;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.models.enums.EstadoPago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponseDTO {
    private  Long id;
    private Long idReserva;
    private LocalDateTime fechaHora;
    private BigDecimal monto;
    private BigDecimal descuentoAplicado;
    private BigDecimal recargoAplicado;
    private Long medioDePagoId;
    private EstadoPago estadoPago;
    private BigDecimal montoTotal;

    public  PagoResponseDTO(){};

    public PagoResponseDTO(Long id, Long idReserva, LocalDateTime fechaHora, BigDecimal monto, BigDecimal descuentoAplicado, BigDecimal recargoAplicado, Long medioDePagoId, EstadoPago estadoPago, BigDecimal montoTotal) {
        this.id = id;
        this.idReserva = idReserva;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.descuentoAplicado = descuentoAplicado;
        this.recargoAplicado = recargoAplicado;
        this.medioDePagoId = medioDePagoId;
        this.estadoPago = estadoPago;
        this.montoTotal = montoTotal;
    }

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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
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

    public Long getMedioDePagoId() {
        return medioDePagoId;
    }

    public void setMedioDePagoId(Long medioDePagoId) {
        this.medioDePagoId = medioDePagoId;
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
}
