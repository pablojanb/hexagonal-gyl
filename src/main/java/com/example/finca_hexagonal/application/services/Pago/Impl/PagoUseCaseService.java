package com.example.finca_hexagonal.application.services.Pago.Impl;

import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.ports.in.pago.CreatePagoUseCase;
import com.example.finca_hexagonal.domain.ports.in.pago.DeletePagoUseCase;
import com.example.finca_hexagonal.domain.ports.in.pago.GetPagoUseCase;
import com.example.finca_hexagonal.domain.ports.in.pago.UpdatePagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.PagoModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoUseCaseService implements
        CreatePagoUseCase,
        DeletePagoUseCase,
        UpdatePagoUseCase,
        GetPagoUseCase {

    private final PagoModelPort pagoModelPort;

    public PagoUseCaseService(PagoModelPort pagoModelPort) {
        this.pagoModelPort = pagoModelPort;
    }

    @Override
    public Pago save(Pago pago) {
        return pagoModelPort.save(pago);
    }

    @Override
    public boolean deletePago(Long pagoId) {
        return pagoModelPort.deletedById(pagoId);
    }

    @Override
    public List<Pago> getAllPago() {
        return pagoModelPort.FindAll();
    }

    @Override
    public Optional<Pago> getPagoById(Long pagoId) {
        return pagoModelPort.findBYId(pagoId);
    }

    @Override
    public Optional<Pago> updatePago(Long pagoId, Pago updatePago) {
        return pagoModelPort.updateById(pagoId, updatePago);
    }
}
