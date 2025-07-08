package com.example.finca_hexagonal.application.usecases.authentication;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.authentication.CreateUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.out.AuthenticationModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUsuarioUseCaseImpl implements CreateUsuarioUseCase {

    private final AuthenticationModelPort authenticationModelPort;

    public CreateUsuarioUseCaseImpl(AuthenticationModelPort authenticationModelPort) {
        this.authenticationModelPort = authenticationModelPort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return authenticationModelPort.save(usuario);
    }
}
