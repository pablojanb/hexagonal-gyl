package com.example.finca_hexagonal.infrastructure.controllers;


import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialRequestDTO;
import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialResponseDTO;
import com.example.finca_hexagonal.application.services.fechaEspecial.FechaEspecialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fechaEspecial")
public class FechaEspecialController {
    private final FechaEspecialService fechaEspecialService;

    public FechaEspecialController(FechaEspecialService fincaService) {
        this.fechaEspecialService = fincaService;
    }


    @PostMapping
    public ResponseEntity<FechaEspecialResponseDTO> create(@RequestBody FechaEspecialRequestDTO fechaEspecial) {
        return new ResponseEntity<>(fechaEspecialService.create(fechaEspecial), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FechaEspecialResponseDTO>> getAll() {
        return new ResponseEntity<>(fechaEspecialService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<FechaEspecialResponseDTO> getById(@PathVariable Long id) {
        return fechaEspecialService.getById(id)
                .map(horario -> new ResponseEntity<>(horario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findAllFechaEspecialByFincaId/{fincaId}")
    public ResponseEntity <List<FechaEspecialResponseDTO>> findAllFechaEspecialByFincaId(@PathVariable Long fincaId) {
        return new ResponseEntity<>(fechaEspecialService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idfecha}")
    public ResponseEntity<FechaEspecialResponseDTO> delete(@PathVariable Long idfecha) {
        if (fechaEspecialService.delete(idfecha)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
