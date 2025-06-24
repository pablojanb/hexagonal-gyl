package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.services.FincaService;
import com.example.finca_hexagonal.domain.models.Finca;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fincas")
public class FincaController {

    private final FincaService fincaService;

    public FincaController(FincaService fincaService) {
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
    public ResponseEntity<Finca> getFincaById(@PathVariable int fincaId){
        return new ResponseEntity<>(fincaService.getFincaById(fincaId), HttpStatus.OK);
    }

    @PutMapping("/updateFinca/{fincaId}")
    public ResponseEntity<Finca> updateFinca(@PathVariable int fincaId,
                             @RequestBody Finca finca){
        return new ResponseEntity<>(fincaService.updateFinca(fincaId, finca), HttpStatus.OK);
    }

    @DeleteMapping("/deleteFincaById/{fincaId}")
    public ResponseEntity<Void> deleteFincaById(@PathVariable int fincaId){
        if (fincaService.deleteFincaById(fincaId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
