package com.example.finca_hexagonal.application.dto.reserva;

import java.security.PublicKey;
import java.util.Date;

public class ReservaDTOResponse {

    private Long fincaId;

    private Long clienteId;

    private Date desde;

    private Date hasta;

    private Boolean estadoReserva;

    public  ReservaDTOResponse(){

    };

    public ReservaDTOResponse(Long fincaId, Long clienteId, Date desde, Date hasta, Boolean estadoReserva) {
        this.fincaId = fincaId;
        this.clienteId = clienteId;
        this.desde = desde;
        this.hasta = hasta;
        this.estadoReserva = estadoReserva;
    }

    public Long getFincaId() {
        return fincaId;
    }

    public void setFincaId(Long fincaId) {
        this.fincaId = fincaId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
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

    public Boolean getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(Boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
