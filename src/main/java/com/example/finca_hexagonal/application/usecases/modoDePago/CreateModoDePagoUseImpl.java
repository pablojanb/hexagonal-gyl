package com.example.finca_hexagonal.application.usecases.modoDePago;

import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.CreateModoDepagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.ModoDePagoModelPort;

public class CreateModoDePagoUseImpl implements CreateModoDepagoUseCase {

    private final ModoDePagoModelPort modoDePagoModelPort;

    public CreateModoDePagoUseImpl(ModoDePagoModelPort modoDePagoModelPort) {
        this.modoDePagoModelPort = modoDePagoModelPort;
    }


    @Override
    public ModoDePago save(ModoDePago modoDePago) {
        return modoDePagoModelPort.save( modoDePago);
    }
}
