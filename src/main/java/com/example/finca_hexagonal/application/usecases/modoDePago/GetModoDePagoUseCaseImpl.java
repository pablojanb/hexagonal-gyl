package com.example.finca_hexagonal.application.usecases.modoDePago;

import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.GetModoDePagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.ModoDePagoModelPort;

import java.util.List;
import java.util.Optional;

public class GetModoDePagoUseCaseImpl implements GetModoDePagoUseCase {

    private final ModoDePagoModelPort modoDePagoModelPort;

    public GetModoDePagoUseCaseImpl(ModoDePagoModelPort modoDePagoModelPort) {
        this.modoDePagoModelPort = modoDePagoModelPort;
    }

    @Override
    public Optional<ModoDePago> getById(Long id) {
        return modoDePagoModelPort.getById(id);
    }

    @Override
    public List<ModoDePago> getAll() {
        return modoDePagoModelPort.getAll();
    }
}
