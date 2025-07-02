package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.direccion.DireccionDTORequest;
import com.example.finca_hexagonal.application.dto.direccion.DireccionDTOResponse;
import com.example.finca_hexagonal.application.services.Direccion.DireccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService){
        this.direccionService = direccionService;
    }

    @PostMapping
    public ResponseEntity<DireccionDTOResponse> createDireccion(@RequestBody DireccionDTORequest direccionDTO){
        return new ResponseEntity<>(direccionService.createDireccion(direccionDTO), HttpStatus.CREATED);
    }
}
