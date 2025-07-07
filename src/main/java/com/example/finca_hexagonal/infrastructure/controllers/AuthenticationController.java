package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.authentication.AuthenticationRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthenticationResponseDTO;
import com.example.finca_hexagonal.application.services.authentication.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> validarUsuarioCredenciales(@RequestBody AuthenticationRequestDTO authDto){
        return authenticationService.validarUsuarioCredenciales(authDto)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
