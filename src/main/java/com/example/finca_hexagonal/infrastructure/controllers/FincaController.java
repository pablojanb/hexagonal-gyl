package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.services.FincaService.impl.FincaModelService;
import com.example.finca_hexagonal.domain.models.Finca;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fincas")
public class FincaController {

    private final FincaModelService fincaService;

    public FincaController(FincaModelService fincaService) {
        this.fincaService = fincaService;
    }


    @PostMapping
    public ResponseEntity<Finca> createFinca(Finca finca){
        return new ResponseEntity<>(fincaService.createFinca(finca), HttpStatus.CREATED);
    }

    @GetMapping("/getAllFincas")
    public ResponseEntity<List<Finca>> getAllFincas(){
        return new ResponseEntity<>(fincaService.getAllFincas(), HttpStatus.OK);
    }

    @GetMapping("/getFincaById/{fincaId}")
    public ResponseEntity<Finca> getFincaById(@PathVariable Long fincaId){
        return fincaService.getFincaById(fincaId)
                .map(finca -> new ResponseEntity<>(finca, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateFinca/{fincaId}")
    public ResponseEntity<Finca> updateFinca(@PathVariable Long fincaId,
                             @RequestBody Finca fincaUpdate){
        return fincaService.updateFinca(fincaId, fincaUpdate)
                .map(finca -> new ResponseEntity<>(finca, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteFincaById/{fincaId}")
    public ResponseEntity<Void> deleteFincaById(@PathVariable Long fincaId){
        if (fincaService.deleteFincaById(fincaId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
