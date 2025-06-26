package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.application.services.usuario.IUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/find/username/{username}")
    public ResponseEntity<UsuarioResponseDTO> findUsuariolByUsername(@PathVariable String username){
        return ResponseEntity.ok(usuarioService.findByUsername(username));
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<UsuarioResponseDTO> findUsuarioById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<UsuarioResponseDTO>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<UsuarioResponseDTO> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.deleteById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return ResponseEntity.ok(usuarioService.create(usuarioRequestDTO));
    }

}
