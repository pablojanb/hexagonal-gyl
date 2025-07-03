package com.example.finca_hexagonal.application.usecases.modoDePago;

import com.example.finca_hexagonal.domain.ports.in.modoDePago.DeleteModoDePagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.ModoDePagoModelPort;

public class DeleteModoDePagoUseCaseImpl implements DeleteModoDePagoUseCase {

    private final ModoDePagoModelPort modoDePagoModelPort;

    public DeleteModoDePagoUseCaseImpl(ModoDePagoModelPort modoDePagoModelPort) {
        this.modoDePagoModelPort = modoDePagoModelPort;
    }

    @Override
    public boolean deleteById(Long id) {
        return modoDePagoModelPort.deleteById(id);
    }
}
