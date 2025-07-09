package com.example.finca_hexagonal.application.services.authentication.impl;

import com.example.finca_hexagonal.application.dto.authentication.AuthLoginRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthRegistroRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthenticationResponseDTO;
import com.example.finca_hexagonal.application.mappers.AuthenticationDTOMapper;
import com.example.finca_hexagonal.application.services.authentication.AuthenticationService;
import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.infrastructure.exceptions.InvalidCredentialsException;
import com.example.finca_hexagonal.infrastructure.utils.JWTUtil;
import com.example.finca_hexagonal.infrastructure.utils.Password;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationModelService authenticationModelService;
    private final AuthenticationDTOMapper authenticationDTOMapper;
    private final JWTUtil jwtUtil;

    public AuthenticationServiceImpl(AuthenticationModelService authenticationModelService, AuthenticationDTOMapper authenticationDTOMapper, JWTUtil jwtUtil) {
        this.authenticationModelService = authenticationModelService;
        this.authenticationDTOMapper = authenticationDTOMapper;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthenticationResponseDTO createUsuario(AuthRegistroRequestDTO usuarioDto) {
        Usuario usuario = authenticationDTOMapper.toModelFromRegistroDto(usuarioDto);
        String hashPassword = Password.hashPassword(usuario.getPassword());
        usuario.setPassword(hashPassword);
        Usuario newUsuario = authenticationModelService.createUsuario(usuario);
        String tokenJwt = jwtUtil.create(String.valueOf(newUsuario.getId()), newUsuario.getEmail());
        AuthenticationResponseDTO responseDTO = authenticationDTOMapper.toDto(newUsuario);
        responseDTO.setJwtToken(tokenJwt);
        return responseDTO;
    }

    @Override
    public Optional<AuthenticationResponseDTO> validarUsuarioCredenciales(AuthLoginRequestDTO authDTO) {
        Usuario usuario = authenticationDTOMapper.toModel(authDTO);
        Usuario usuarioLogueado;

        if (usuario.getEmail().equalsIgnoreCase("") || usuario.getEmail() == null) {
            usuarioLogueado = authenticationModelService.getByUsername(usuario.getUsername());
        } else {
            usuarioLogueado = authenticationModelService.getByEmail(usuario.getEmail());
        }

        if (usuarioLogueado == null) {
            throw new InvalidCredentialsException("Credenciales inválidas");
        }

        boolean credencialesCorrectas = Password.verificarPassword(authDTO.getPassword(), usuarioLogueado);
        if (!credencialesCorrectas){
            throw new InvalidCredentialsException("Credenciales inválidas");
        }
        String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
        AuthenticationResponseDTO responseDTO = authenticationDTOMapper.toDto(usuarioLogueado);
        responseDTO.setJwtToken(tokenJwt);
        return Optional.of(responseDTO);
    }
}
