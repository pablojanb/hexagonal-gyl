package com.example.finca_hexagonal.application.dto.reserva;

import java.util.Date;

public class ReservaResponseDTO {

    private Long id_finca;

    private Long id_cliente;

    private Date desde;

    private Date hasta;

    private Boolean estadoReserva;

    public ReservaResponseDTO(){

    };

    public ReservaResponseDTO(Long fincaId, Long clienteId, Date desde, Date hasta, Boolean estadoReserva) {
        this.id_finca = fincaId;
        this.id_cliente = clienteId;
        this.desde = desde;
        this.hasta = hasta;
        this.estadoReserva = estadoReserva;
    }

    public Long getId_finca() {
        return id_finca;
    }

    public void setId_finca(Long id_finca) {
        this.id_finca = id_finca;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
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
