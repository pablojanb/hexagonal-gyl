package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoRequestDTO;
import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoResponseDTO;
import com.example.finca_hexagonal.application.services.ModoDePago.ModoDePagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<ModoDePagoResponseDTO> resultado = modoDePagoService.getById(id);

        if (resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el modo de pago con el ID: " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ModoDePagoRequestDTO dto) {
        return modoDePagoService.updateById(id, dto)
                .map(updated -> ResponseEntity.ok("Modo de pago con ID " + id + " actualizado correctamente."))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontró un modo de pago con ID " + id + ". No se pudo actualizar."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        List<ModoDePagoResponseDTO> modos = modoDePagoService.getAll();

        if (modos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen modos de pago registrados. Por favor, agregue uno primero.");
        }

        return modoDePagoService.getById(id)
                .map(modo -> {
                    boolean deleted = modoDePagoService.delete(id);
                    if (deleted) {
                        return ResponseEntity.ok("Modo de pago eliminado correctamente.");
                    } else {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Ocurrió un error al eliminar el modo de pago.");
                    }
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Modo de pago con ID " + id + " no encontrado."));
    }


}
