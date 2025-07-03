package com.example.finca_hexagonal.application.usecases.modoDePago;

import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.UpdateModoDePagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.ModoDePagoModelPort;

import java.util.Optional;

public class UpdateModoDePagoUseCaseImpl implements UpdateModoDePagoUseCase {

    private final ModoDePagoModelPort modoDePagoModelPort;

    public UpdateModoDePagoUseCaseImpl(ModoDePagoModelPort modoDePagoModelPort) {
        this.modoDePagoModelPort = modoDePagoModelPort;
    }

    @Override
    public Optional<ModoDePago> updateById(Long id, ModoDePago modoDePago) {
        return Optional.empty();
    }
}
