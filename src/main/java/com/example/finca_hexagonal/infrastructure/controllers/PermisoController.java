package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.application.services.permiso.IPermisoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permiso")
public class PermisoController {

    private IPermisoService permisoService;

    public PermisoController(IPermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<PermisoResponseDTO>> findAllPermiso(){
        return ResponseEntity.ok(permisoService.findAll());
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<PermisoResponseDTO> findPermisoById(@PathVariable Long id){
        return ResponseEntity.ok(permisoService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PermisoResponseDTO> createPermiso(@RequestBody PermisoRequestDTO  permisoRequestDTO){
        return ResponseEntity.ok(permisoService.create(permisoRequestDTO));
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<PermisoResponseDTO> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(permisoService.deleteById(id));
    }
}
