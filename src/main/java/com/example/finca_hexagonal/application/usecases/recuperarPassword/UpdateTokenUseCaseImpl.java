package com.example.finca_hexagonal.application.usecases.recuperarPassword;

import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import com.example.finca_hexagonal.domain.ports.in.recuperarPassword.UpdateTokenUseCase;
import com.example.finca_hexagonal.domain.ports.out.RecuperarPasswordModelPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateTokenUseCaseImpl implements UpdateTokenUseCase {

    private final RecuperarPasswordModelPort recuperarPasswordModelPort;

    public UpdateTokenUseCaseImpl(RecuperarPasswordModelPort recuperarPasswordModelPort) {
        this.recuperarPasswordModelPort = recuperarPasswordModelPort;
    }

    @Override
    public RecuperarPassword updateToken(Long id, RecuperarPassword recuperarPassword) {
        return recuperarPasswordModelPort.update(id, recuperarPassword);
    }
}
