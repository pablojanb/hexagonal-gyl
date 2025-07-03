package com.example.finca_hexagonal.application.usecases.pago;

import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.ports.in.pago.GetPagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PagoModelPort;

import java.util.List;
import java.util.Optional;

public class GetPagoUseCaseImpl implements GetPagoUseCase {

    private final PagoModelPort pagoModelPort;

    public GetPagoUseCaseImpl(PagoModelPort pagoModelPort) {
        this.pagoModelPort = pagoModelPort;
    }


    @Override
    public List<Pago> getAllPago() {
        return pagoModelPort.FindAll();
    }

    @Override
    public Optional<Pago> getPagoById(Long pagoId) {
        return pagoModelPort.findBYId(pagoId);
    }
}
