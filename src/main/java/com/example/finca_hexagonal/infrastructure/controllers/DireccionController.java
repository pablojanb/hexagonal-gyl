package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.direccion.DireccionDTORequest;
import com.example.finca_hexagonal.application.dto.direccion.DireccionDTOResponse;
import com.example.finca_hexagonal.application.services.Direccion.DireccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllDirecciones")
    public ResponseEntity<List<DireccionDTOResponse>> getAllDirecciones(){
        return new ResponseEntity<>(direccionService.getAllDirecciones(), HttpStatus.OK);
    }

    @GetMapping("/getDireccionById/{extraId}")
    public ResponseEntity<DireccionDTOResponse> getDireccionById(@PathVariable Long extraId){
        return direccionService.getDireccionById(extraId)
                .map(direccion -> new ResponseEntity<>(direccion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateDireccion/{direccionId}")
    public ResponseEntity<DireccionDTOResponse> updateDireccion(@PathVariable Long direccionId,
                                                        @RequestBody DireccionDTORequest direccionUpdate){
        return direccionService.updateDireccionById(direccionId, direccionUpdate)
                .map(direccion -> new ResponseEntity<>(direccion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteDireccionById/{extraId}")
    public ResponseEntity<Void> deleteDireccionById(@PathVariable Long extraId){
        if (direccionService.deleteById(extraId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
