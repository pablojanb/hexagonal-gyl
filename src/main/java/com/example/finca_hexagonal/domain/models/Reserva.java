package com.example.finca_hexagonal.domain.models;

import java.math.BigDecimal;
import java.util.Date;

public class Reserva {
    private Long id;
    private Long finca_id;
    private Long cliente_id;
    private Date desde;
    private Date hasta;
    private BigDecimal total;
    private Boolean estado_reserva;


    public Reserva(){

    };

    public Reserva(Long id, Long finca_id, Long cliente_id, Date desde, Date hasta, BigDecimal total, Boolean estado_reserva) {
        this.id = id;
        this.finca_id = finca_id;
        this.cliente_id = cliente_id;
        this.desde = desde;
        this.hasta = hasta;
        this.total = total;
        this.estado_reserva = estado_reserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFinca_id() {
        return finca_id;
    }

    public void setFinca_id(Long finca_id) {
        this.finca_id = finca_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(Boolean estado_reserva) {
        this.estado_reserva = estado_reserva;
    }
}