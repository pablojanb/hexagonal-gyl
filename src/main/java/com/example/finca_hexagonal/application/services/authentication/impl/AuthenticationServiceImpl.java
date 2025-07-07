package com.example.finca_hexagonal.application.services.authentication.impl;

import com.example.finca_hexagonal.application.dto.authentication.AuthenticationRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthenticationResponseDTO;
import com.example.finca_hexagonal.application.mappers.AuthenticationDTOMapper;
import com.example.finca_hexagonal.application.services.authentication.AuthenticationService;
import com.example.finca_hexagonal.domain.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationModelService authenticationModelService;
    private final AuthenticationDTOMapper authenticationDTOMapper;

    public AuthenticationServiceImpl(AuthenticationModelService authenticationModelService, AuthenticationDTOMapper authenticationDTOMapper) {
        this.authenticationModelService = authenticationModelService;
        this.authenticationDTOMapper = authenticationDTOMapper;
    }

    @Override
    public Optional<AuthenticationResponseDTO> validarUsuarioCredenciales(AuthenticationRequestDTO authDTO) {
        Usuario usuario = authenticationDTOMapper.toModel(authDTO);
        Usuario newUsuario =authenticationModelService.validarUsuarioCredenciales(usuario.getEmail(), usuario.getPassword());
        System.out.println("validarpasword");
        return Optional.of(authenticationDTOMapper.toDto(newUsuario));
    }
}
