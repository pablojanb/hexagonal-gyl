package com.example.finca_hexagonal.application.usecases.pago;

import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.ports.in.pago.CreatePagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PagoModelPort;

public class CreatePagoUseCaseImpl implements CreatePagoUseCase {

    private final PagoModelPort pagoModelPort;

    public CreatePagoUseCaseImpl(PagoModelPort pagoModelPort){
     this.pagoModelPort = pagoModelPort;
    }

    @Override
    public Pago save(Pago pago) {
        return pagoModelPort.save(pago);
    }
}
