package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.ports.in.DetalleFincaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetalleFincaController {

    private final DetalleFincaService service;

    public DetalleFincaController(DetalleFincaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DetalleFinca> crear(@RequestBody DetalleFinca detalle) {
        return ResponseEntity.ok(service.crearDetalle(detalle));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFinca> obtener(@PathVariable Long id) {
        DetalleFinca detalle = service.obtenerPorId(id);
        return (detalle != null) ? ResponseEntity.ok(detalle) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DetalleFinca>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping
    public ResponseEntity<DetalleFinca> actualizar(@RequestBody DetalleFinca detalle) {
        return ResponseEntity.ok(service.actualizarDetalle(detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarDetalle(id);
        return ResponseEntity.noContent().build();
    }
}
