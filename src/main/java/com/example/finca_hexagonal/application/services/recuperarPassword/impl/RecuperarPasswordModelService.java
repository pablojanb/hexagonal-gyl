package com.example.finca_hexagonal.application.services.recuperarPassword.impl;

import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import com.example.finca_hexagonal.domain.ports.in.recuperarPassword.GenerarTokenUseCase;
import com.example.finca_hexagonal.domain.ports.in.recuperarPassword.ObtenerTokenUseCase;
import org.springframework.stereotype.Service;

@Service
public class RecuperarPasswordModelService implements GenerarTokenUseCase, ObtenerTokenUseCase {

    private final GenerarTokenUseCase generarTokenUseCase;
    private final ObtenerTokenUseCase obtenerTokenUseCase;

    public RecuperarPasswordModelService(GenerarTokenUseCase generarTokenUseCase, ObtenerTokenUseCase obtenerTokenUseCase) {
        this.generarTokenUseCase = generarTokenUseCase;
        this.obtenerTokenUseCase = obtenerTokenUseCase;
    }

    @Override
    public RecuperarPassword generarToken(RecuperarPassword recuperarPassword) {
        return generarTokenUseCase.generarToken(recuperarPassword);
    }

    @Override
    public RecuperarPassword obtenerToken(String email) {
        return obtenerTokenUseCase.obtenerToken(email);
    }
}
