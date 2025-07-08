package com.example.finca_hexagonal.application.services.authentication.impl;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.authentication.CreateUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.authentication.LoginUseCase;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationModelService implements LoginUseCase, CreateUsuarioUseCase {

    private final LoginUseCase loginUseCase;
    private final CreateUsuarioUseCase createUsuarioUseCase;

    public AuthenticationModelService(LoginUseCase loginUseCase, CreateUsuarioUseCase createUsuarioUseCase) {
        this.loginUseCase = loginUseCase;
        this.createUsuarioUseCase = createUsuarioUseCase;
    }


    @Override
    public Usuario getByEmail(String email) {
        return loginUseCase.getByEmail(email);
    }

    @Override
    public Usuario getByUsername(String username) {
        return loginUseCase.getByUsername(username);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return createUsuarioUseCase.createUsuario(usuario);
    }
}
