package com.example.finca_hexagonal.application.services.recuperarPassword.impl;

import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import com.example.finca_hexagonal.domain.ports.in.recuperarPassword.GenerarTokenUseCase;
import com.example.finca_hexagonal.domain.ports.in.recuperarPassword.ObtenerTokenUseCase;
import com.example.finca_hexagonal.domain.ports.in.recuperarPassword.UpdateTokenUseCase;
import org.springframework.stereotype.Service;

@Service
public class RecuperarPasswordModelService implements GenerarTokenUseCase, ObtenerTokenUseCase, UpdateTokenUseCase {

    private final GenerarTokenUseCase generarTokenUseCase;
    private final ObtenerTokenUseCase obtenerTokenUseCase;
    private final UpdateTokenUseCase updateTokenUseCase;

    public RecuperarPasswordModelService(GenerarTokenUseCase generarTokenUseCase,
                                         ObtenerTokenUseCase obtenerTokenUseCase,
                                         UpdateTokenUseCase updateTokenUseCase) {
        this.generarTokenUseCase = generarTokenUseCase;
        this.obtenerTokenUseCase = obtenerTokenUseCase;
        this.updateTokenUseCase = updateTokenUseCase;
    }

    @Override
    public RecuperarPassword generarToken(RecuperarPassword recuperarPassword) {
        return generarTokenUseCase.generarToken(recuperarPassword);
    }

    @Override
    public RecuperarPassword obtenerToken(String email) {
        return obtenerTokenUseCase.obtenerToken(email);
    }

    @Override
    public RecuperarPassword updateToken(Long id, RecuperarPassword recuperarPassword) {
        return updateTokenUseCase.updateToken(id, recuperarPassword);
    }
}
