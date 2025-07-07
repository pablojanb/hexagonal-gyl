package com.example.finca_hexagonal.application.services.authentication.impl;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.authentication.LoginUseCase;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationModelService implements LoginUseCase {

    private final LoginUseCase loginUseCase;

    public AuthenticationModelService(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }


    @Override
    public Usuario validarUsuarioCredenciales(String email, String password) {
        return loginUseCase.validarUsuarioCredenciales(email, password);
    }
}
