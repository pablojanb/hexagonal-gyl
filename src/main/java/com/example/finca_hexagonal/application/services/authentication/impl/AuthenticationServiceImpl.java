package com.example.finca_hexagonal.application.services.authentication.impl;

import com.example.finca_hexagonal.application.dto.authentication.AuthLoginRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthRegistroRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthenticationResponseDTO;
import com.example.finca_hexagonal.application.mappers.AuthenticationDTOMapper;
import com.example.finca_hexagonal.application.services.authentication.AuthenticationService;
import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.infrastructure.utils.Password;
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
    public AuthenticationResponseDTO createUsuario(AuthRegistroRequestDTO usuarioDto) {
        Usuario usuario = authenticationDTOMapper.toModelFromRegistroDto(usuarioDto);
        String hashPassword = Password.hashPassword(usuario.getPassword());
        usuario.setPassword(hashPassword);
        Usuario newUsuario = authenticationModelService.createUsuario(usuario);
        return authenticationDTOMapper.toDto(newUsuario);
    }

    @Override
    public Optional<AuthenticationResponseDTO> validarUsuarioCredenciales(AuthLoginRequestDTO authDTO) {
        Usuario usuario = authenticationDTOMapper.toModel(authDTO);
        Usuario newUsuario = authenticationModelService.getByEmail(usuario.getEmail());
        boolean credencialesCorrectas = Password.verificarPassword(authDTO.getPassword(), newUsuario);
        if (!credencialesCorrectas){
            return Optional.empty();
        }
        return Optional.of(authenticationDTOMapper.toDto(newUsuario));
    }
}
