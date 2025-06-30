package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.fincas.FincaRequestDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTOSimplified;
import com.example.finca_hexagonal.application.services.FincaService.FincaService;
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
    public ResponseEntity<FincaResponseDTOSimplified> createFinca(@RequestBody FincaRequestDTO fincaDTO){

        return new ResponseEntity<>(fincaService.createFinca(fincaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllFincas")
    public ResponseEntity<List<FincaResponseDTOSimplified>> getAllFincas(){
        return new ResponseEntity<>(fincaService.getAllFincas(), HttpStatus.OK);
    }

    @GetMapping("/getFincaById/{fincaId}")
    public ResponseEntity<FincaResponseDTOSimplified> getFincaById(@PathVariable Long fincaId){
        return fincaService.getFincaById(fincaId)
                .map(finca -> new ResponseEntity<>(finca, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateFinca/{fincaId}")
    public ResponseEntity<FincaResponseDTOSimplified> updateFinca(@PathVariable Long fincaId,
                                                                  @RequestBody FincaRequestDTO fincaUpdate){
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
