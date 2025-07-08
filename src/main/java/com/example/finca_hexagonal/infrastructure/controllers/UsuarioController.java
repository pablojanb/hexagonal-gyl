package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.application.services.usuario.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/getAllUsuarios")
    public ResponseEntity<List<UsuarioResponseDTO>> getAllUsuarios(){
        return new ResponseEntity<>(usuarioService.getAllUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/getUsuarioById/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> getUsuarioById(@PathVariable Long usuarioId){
        return usuarioService.getUsuarioById(usuarioId)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateUsuario/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> updateFinca(@PathVariable Long usuarioId,
                                                                  @RequestBody UsuarioRequestDTO usuarioUpdate){
        return usuarioService.updateById(usuarioId, usuarioUpdate)
                .map(finca -> new ResponseEntity<>(finca, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteUsuarioById/{usuarioId}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long usuarioId){
        if (usuarioService.deleteUsuarioById(usuarioId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
