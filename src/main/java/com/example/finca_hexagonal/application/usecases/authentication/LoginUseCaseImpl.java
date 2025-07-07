package com.example.finca_hexagonal.application.usecases.authentication;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.authentication.LoginUseCase;
import com.example.finca_hexagonal.domain.ports.out.AuthenticationModelPort;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCaseImpl implements LoginUseCase {
    private final AuthenticationModelPort authenticationModelPort;

    public LoginUseCaseImpl(AuthenticationModelPort authenticationModelPort) {
        this.authenticationModelPort = authenticationModelPort;
    }

    @Override
    public Usuario validarUsuarioCredenciales(String email, String password) {
        return authenticationModelPort.findByEmail(email, password);
    }
}
