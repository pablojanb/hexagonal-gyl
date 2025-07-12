package com.example.finca_hexagonal.application.dto.pago;

import com.example.finca_hexagonal.domain.models.enums.MedioPago;

public class PagoRequestDTO {

    private Long reservaId;

    private MedioPago medioPago;


    public PagoRequestDTO() {
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }
}