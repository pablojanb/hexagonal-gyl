package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoRequestDTO;
import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoResponseDTO;
import com.example.finca_hexagonal.application.services.ModoDePago.ModoDePagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modo-de-pago")
public class ModoDePagoController {

    private final ModoDePagoService modoDePagoService;

    public ModoDePagoController(ModoDePagoService modoDePagoService) {
        this.modoDePagoService = modoDePagoService;
    }

    @PostMapping
    public ResponseEntity<ModoDePagoResponseDTO> create(@RequestBody ModoDePagoRequestDTO dto) {
        ModoDePagoResponseDTO created = modoDePagoService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ModoDePagoResponseDTO>> getAll() {
        return new ResponseEntity<>(modoDePagoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModoDePagoResponseDTO> getById(@PathVariable Long id) {
        return modoDePagoService.getById(id)
                .map(modo -> new ResponseEntity<>(modo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModoDePagoResponseDTO> update(@PathVariable Long id, @RequestBody ModoDePagoRequestDTO dto) {
        return modoDePagoService.updateById(id, dto)
                .map(updated -> new ResponseEntity<>(updated, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (modoDePagoService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
