package com.example.finca_hexagonal.domain.ports.in.authentication;

import com.example.finca_hexagonal.domain.models.Usuario;

public interface LoginUseCase {
    Usuario validarUsuarioCredenciales(String email, String password);
}
