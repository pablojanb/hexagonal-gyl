package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.pago.PagoRequestDTO;
import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;
import com.example.finca_hexagonal.application.services.Pago.PagoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<PagoResponseDTO> createPago(@RequestBody PagoRequestDTO dto) {
        PagoResponseDTO created = pagoService.save(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<PagoResponseDTO>> getAllPagos() {
        return new ResponseEntity<>(pagoService.getAllPagos(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PagoResponseDTO> getPagoById(@PathVariable Long id) {
        return pagoService.getPagoById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<PagoResponseDTO> updatePago(@PathVariable Long id, @RequestBody PagoRequestDTO dto) {
        return pagoService.updatePago(id, dto)
                .map(updated -> new ResponseEntity<>(updated, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        boolean deleted = pagoService.deletePago(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
