package com.example.finca_hexagonal.application.dto.pago;

public class PagoRequestDTO {

    private Long reservaId;

    private Long medioDePagoId;



    public PagoRequestDTO() {
    }

    public PagoRequestDTO(Long reservaId, Long medioDePagoId) {
        this.reservaId = reservaId;
        this.medioDePagoId = medioDePagoId;

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

}