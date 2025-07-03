package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTORequest;
import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTOResponse;
import com.example.finca_hexagonal.application.services.imagenFinca.ImagenFincaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/imagenes-finca")
public class ImagenFincaController {

    private final ImagenFincaService imagenFincaService;

    public ImagenFincaController(ImagenFincaService imagenFincaService) {
        this.imagenFincaService = imagenFincaService;
    }

    @PostMapping
    public ResponseEntity<ImagenFincaDTOResponse> createImagenFinca(@RequestBody ImagenFincaDTORequest imagenDto){
        return new ResponseEntity<>(imagenFincaService.createImagen(imagenDto), HttpStatus.CREATED);
    }
}
