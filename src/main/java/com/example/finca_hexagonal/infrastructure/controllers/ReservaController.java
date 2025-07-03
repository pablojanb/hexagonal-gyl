//package com.example.finca_hexagonal.infrastructure.controllers;
//
//import com.example.finca_hexagonal.application.dto.reservas.ReservaRequestDTO;
//import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
//import com.example.finca_hexagonal.application.services.reserva.ReservaService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/reservas")
//public class ReservaController {
//    private final ReservaService reservaService;
//
//    public ReservaController(ReservaService reservaService) {
//        this.reservaService = reservaService;
//    }
//
//    @PostMapping
//    public ResponseEntity<ReservaResponseDTO> createReserva(@RequestBody ReservaRequestDTO reservaDTO){
//        return new ResponseEntity<>(reservaService.create(reservaDTO), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/deleteReservaById/{reservaId}")
//    public ResponseEntity<Void> deleteReservaById(@PathVariable Long reservaId){
//        if (reservaService.deleteById(reservaId)){
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/getAllReservas")
//    public ResponseEntity<List<ReservaResponseDTO>> getAllReservas(){
//        return new ResponseEntity<>(reservaService.getAll(), HttpStatus.OK);
//    }
//
//    @GetMapping("/getReservaById/{reservaId}")
//    public ResponseEntity<ReservaResponseDTO> getReservaById(@PathVariable Long reservaId){
//        return reservaService.getById(reservaId)
//                .map(reserva -> new ResponseEntity<>(reserva, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PutMapping("/updateReserva/{reservaId}")
//    public ResponseEntity<ReservaResponseDTO> updateReserva(@PathVariable Long reservaId,
//                                                            @RequestBody ReservaRequestDTO reservaUpdate){
//        return reservaService.updateById(reservaId, reservaUpdate)
//                .map(reserva -> new ResponseEntity<>(reserva, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//}
package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.reservas.ReservaRequestDTO;
import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
import com.example.finca_hexagonal.application.services.reserva.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<?> createReserva(@RequestBody ReservaRequestDTO reservaDTO) {
        try {
            ReservaResponseDTO response = reservaService.create(reservaDTO);
            if (response.getId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("No se pudo crear la reserva: Verifique si la finca o el usuario existen.");
            }
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Reserva creada correctamente con ID: " + response.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear la reserva: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteReservaById/{reservaId}")
    public ResponseEntity<String> deleteReservaById(@PathVariable Long reservaId) {
        try {
            if (reservaService.deleteById(reservaId)) {
                return ResponseEntity.ok("Reserva eliminada correctamente.");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Reserva con ID " + reservaId + " no encontrada.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la reserva: " + e.getMessage());
        }
    }

    @GetMapping("/getAllReservas")
    public ResponseEntity<?> getAllReservas() {
        try {
            List<ReservaResponseDTO> reservas = reservaService.getAll();
            if (reservas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hay reservas registradas.");
            }
            return new ResponseEntity<>(reservas, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener las reservas: " + e.getMessage());
        }
    }

    @GetMapping("/getReservaById/{reservaId}")
    public ResponseEntity<?> getReservaById(@PathVariable Long reservaId) {
        try {
            Optional<ReservaResponseDTO> reserva = reservaService.getById(reservaId);
            if (reserva.isPresent()) {
                return ResponseEntity.ok(reserva.get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Reserva con ID " + reservaId + " no encontrada.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar la reserva: " + e.getMessage());
        }
    }

    @PutMapping("/updateReserva/{reservaId}")
    public ResponseEntity<?> updateReserva(@PathVariable Long reservaId,
                                           @RequestBody ReservaRequestDTO reservaUpdate) {
        try {
            Optional<ReservaResponseDTO> updated = reservaService.updateById(reservaId, reservaUpdate);
            if (updated.isPresent()) {
                return ResponseEntity.ok("Reserva actualizada correctamente.");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Reserva con ID " + reservaId + " no encontrada para actualizar.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar la reserva: " + e.getMessage());
        }
    }
}