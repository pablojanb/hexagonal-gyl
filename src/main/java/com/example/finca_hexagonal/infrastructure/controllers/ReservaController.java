package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.reservas.ReservaRequestDTO;
import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
import com.example.finca_hexagonal.application.services.reserva.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> createReserva(@RequestBody ReservaRequestDTO reservaDTO){
        return new ResponseEntity<>(reservaService.create(reservaDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteReservaById/{reservaId}")
    public ResponseEntity<Void> deleteReservaById(@PathVariable Long reservaId){
        if (reservaService.deleteById(reservaId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllReservas")
    public ResponseEntity<List<ReservaResponseDTO>> getAllReservas(){
        return new ResponseEntity<>(reservaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getReservaById/{reservaId}")
    public ResponseEntity<ReservaResponseDTO> getReservaById(@PathVariable Long reservaId){
        return reservaService.getById(reservaId)
                .map(reserva -> new ResponseEntity<>(reserva, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateReserva/{reservaId}")
    public ResponseEntity<ReservaResponseDTO> updateReserva(@PathVariable Long reservaId,
                                                            @RequestBody ReservaRequestDTO reservaUpdate){
        return reservaService.updateById(reservaId, reservaUpdate)
                .map(reserva -> new ResponseEntity<>(reserva, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getReservasByFincaIdAndFecha/{fincaId}/{fecha}")
    public ResponseEntity<List<ReservaResponseDTO>> getReservasByFincaIdAndFecha(@PathVariable Long fincaId,
                                                                           @PathVariable LocalDate fecha){
        return new ResponseEntity<>(reservaService.getReservasByFincaIdAndFecha(fincaId, fecha), HttpStatus.OK);
    }
}