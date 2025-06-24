package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.domain.ports.in.finca.ImagenFincaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenFincaController {

    private final ImagenFincaService service;

    public ImagenFincaController(ImagenFincaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ImagenFinca> crear(@RequestBody ImagenFinca imagen) {
        return ResponseEntity.ok(service.crearImagen(imagen));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenFinca> obtener(@PathVariable Long id) {
        ImagenFinca img = service.obtenerPorId(id);
        return (img != null) ? ResponseEntity.ok(img) : ResponseEntity.notFound().build();
    }

    @GetMapping("/finca/{fincaId}")
    public ResponseEntity<List<ImagenFinca>> listarPorFinca(@PathVariable Long fincaId) {
        return ResponseEntity.ok(service.listarPorFinca(fincaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarImagen(id);
        return ResponseEntity.noContent().build();
    }
}
