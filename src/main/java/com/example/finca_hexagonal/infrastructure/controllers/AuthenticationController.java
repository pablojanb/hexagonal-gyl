package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.authentication.AuthLoginRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthLoginResponseDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.application.services.usuario.UsuarioService;
import com.example.finca_hexagonal.infrastructure.security.service.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserDetailsServiceImpl userDetailsService;
    private final UsuarioService usuarioService;

    public AuthenticationController(UserDetailsServiceImpl userDetailsService,
                                    UsuarioService usuarioService) {
        this.userDetailsService = userDetailsService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponseDTO> createUsuario(@RequestBody UsuarioRequestDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.createUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponseDTO> loginUsuario(@RequestBody AuthLoginRequestDTO authDto){
        return ResponseEntity.ok(userDetailsService.loginUser(authDto));
    }


}
