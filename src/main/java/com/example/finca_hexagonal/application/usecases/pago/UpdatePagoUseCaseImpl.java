package com.example.finca_hexagonal.application.usecases.pago;

import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.ports.in.pago.UpdatePagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PagoModelPort;

import java.util.Optional;

public class UpdatePagoUseCaseImpl implements UpdatePagoUseCase {

    private final PagoModelPort pagoModelPort;

    public UpdatePagoUseCaseImpl(PagoModelPort pagoModelPort) {
        this.pagoModelPort = pagoModelPort;
    }

    @Override
    public Optional<Pago> updatePago(Long pagoId, Pago updatePago){
        return pagoModelPort.updateById(pagoId,updatePago);
    }


}
