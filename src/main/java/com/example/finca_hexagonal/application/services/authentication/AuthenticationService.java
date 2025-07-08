package com.example.finca_hexagonal.application.services.authentication;

import com.example.finca_hexagonal.application.dto.authentication.AuthLoginRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthRegistroRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthenticationResponseDTO;

import java.util.Optional;

public interface AuthenticationService {

    AuthenticationResponseDTO createUsuario(AuthRegistroRequestDTO usuarioDto);

    Optional<AuthenticationResponseDTO> validarUsuarioCredenciales(AuthLoginRequestDTO authLoginRequestDTO);
}
