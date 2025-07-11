package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.application.services.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

    private UsuarioService usuarioService;

    public TestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/seguro/admin")
    private ResponseEntity<String> pruebaSeguraAdmin() {
        return ResponseEntity.ok("Esto es una Prueba Segura con usuario ADMIN");
    }

    @GetMapping("/seguro/cliente")
    private ResponseEntity<String> pruebaSeguraCliente() {
        return ResponseEntity.ok("Esto es una Prueba Segura con usuario CLIENTE");
    }

    @GetMapping("/no/seguro")
    private ResponseEntity<String> pruebaNoSegura() {
        return ResponseEntity.ok("Esto es una Prueba No Segura");
    }

    @GetMapping("/permiso/get/usuarios")
    private ResponseEntity<List<UsuarioResponseDTO>> pruebaSeguraPermisos() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }
}
