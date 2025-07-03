package com.example.finca_hexagonal.application.usecases.pago;

import com.example.finca_hexagonal.domain.ports.in.pago.DeletePagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PagoModelPort;

public class DeleteUseCaseImpl implements DeletePagoUseCase {

    private final PagoModelPort pagoModelPort;

    public DeleteUseCaseImpl(PagoModelPort pagoModelPort) {
        this.pagoModelPort = pagoModelPort;
    }

    @Override
    public boolean deletePago(Long pagoId) {
        return pagoModelPort.deletedById(pagoId);
    }
}
