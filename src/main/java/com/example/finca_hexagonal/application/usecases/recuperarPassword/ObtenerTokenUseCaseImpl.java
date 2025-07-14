package com.example.finca_hexagonal.application.usecases.recuperarPassword;

import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import com.example.finca_hexagonal.domain.ports.in.recuperarPassword.ObtenerTokenUseCase;
import com.example.finca_hexagonal.domain.ports.out.RecuperarPasswordModelPort;
import org.springframework.stereotype.Service;

@Service
public class ObtenerTokenUseCaseImpl implements ObtenerTokenUseCase {

    private final RecuperarPasswordModelPort recuperarPasswordModelPort;

    public ObtenerTokenUseCaseImpl(RecuperarPasswordModelPort recuperarPasswordModelPort) {
        this.recuperarPasswordModelPort = recuperarPasswordModelPort;
    }

    @Override
    public RecuperarPassword obtenerToken(String email) {
        return recuperarPasswordModelPort.findTokenByEmail(email);
    }
}
