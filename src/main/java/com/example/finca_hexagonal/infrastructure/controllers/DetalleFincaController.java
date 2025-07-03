package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTORequest;
import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTOResponse;
import com.example.finca_hexagonal.application.services.DetalleFinca.DetalleFincaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalles")
public class DetalleFincaController {

    private final DetalleFincaService detalleFincaService;

    public DetalleFincaController(DetalleFincaService detalleFincaService){
        this.detalleFincaService = detalleFincaService;
    }

    @PostMapping
    public ResponseEntity<DetalleFincaDTOResponse> createDetalleFinca(@RequestBody DetalleFincaDTORequest detalleDTO){
        return new ResponseEntity<>(detalleFincaService.save(detalleDTO), HttpStatus.CREATED);
    }
}
