package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTORequest;
import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTOResponse;
import com.example.finca_hexagonal.application.services.detalleFinca.DetalleFincaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetalleFincaController {

    private final DetalleFincaService detalleFincaService;

    public DetalleFincaController(DetalleFincaService detalleFincaService){
        this.detalleFincaService = detalleFincaService;
    }

    @PostMapping
    public ResponseEntity<DetalleFincaDTOResponse> createDetalleFinca(@RequestBody DetalleFincaDTORequest detalleDTO){
        return new ResponseEntity<>(detalleFincaService.save(detalleDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllDetalles")
    public ResponseEntity<List<DetalleFincaDTOResponse>> getAllExtras(){
        return new ResponseEntity<>(detalleFincaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getDetalleById/{detalleId}")
    public ResponseEntity<DetalleFincaDTOResponse> getDetalleById(@PathVariable Long detalleId){
        return detalleFincaService.findById(detalleId)
                .map(detalle -> new ResponseEntity<>(detalle, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteDetalleFincaById/{detalleId}")
    public ResponseEntity<Void> deleteDetalleFincaById(@PathVariable Long detalleId){
        if (detalleFincaService.delete(detalleId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
