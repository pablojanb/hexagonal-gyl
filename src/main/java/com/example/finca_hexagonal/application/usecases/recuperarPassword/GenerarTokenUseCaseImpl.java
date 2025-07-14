package com.example.finca_hexagonal.application.usecases.recuperarPassword;

import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import com.example.finca_hexagonal.domain.ports.in.recuperarPassword.GenerarTokenUseCase;
import com.example.finca_hexagonal.domain.ports.out.RecuperarPasswordModelPort;
import org.springframework.stereotype.Service;

@Service
public class GenerarTokenUseCaseImpl implements GenerarTokenUseCase {

    private final RecuperarPasswordModelPort recuperarPasswordModelPort;

    public GenerarTokenUseCaseImpl(RecuperarPasswordModelPort recuperarPasswordModelPort) {
        this.recuperarPasswordModelPort = recuperarPasswordModelPort;
    }

    @Override
    public RecuperarPassword generarToken(RecuperarPassword recuperarPassword) {
        return recuperarPasswordModelPort.save(recuperarPassword);
    }
}
