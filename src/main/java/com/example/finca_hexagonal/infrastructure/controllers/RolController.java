package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.apiresponse.ApiResponseDTO;
import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import com.example.finca_hexagonal.application.services.rol.IRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.MappedInterceptor;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    private final IRolService rolService;

    public RolController(IRolService rolService){
        this.rolService = rolService;
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<RolResponseDTO> findRolById(@PathVariable Long id){
        return ResponseEntity.ok(rolService.findById(id));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<RolResponseDTO>> findAllRol(){
        return ResponseEntity.ok(rolService.findAll());
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<RolResponseDTO> deleteRolById(@PathVariable Long id){
        return ResponseEntity.ok(rolService.deleteById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<RolResponseDTO> createRol(@RequestBody RolRequestDTO rolRequestDTO){
        return ResponseEntity.ok(rolService.create(rolRequestDTO));
    }

}
