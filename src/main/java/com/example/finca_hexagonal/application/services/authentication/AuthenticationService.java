package com.example.finca_hexagonal.application.services.authentication;

import com.example.finca_hexagonal.application.dto.authentication.AuthenticationRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthenticationResponseDTO;

import java.util.Optional;

public interface AuthenticationService {
    Optional<AuthenticationResponseDTO> validarUsuarioCredenciales(AuthenticationRequestDTO authenticationRequestDTO);
}
