package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.application.services.permiso.PermisoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    private final PermisoService permisoService;

    public PermisoController(PermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @PostMapping
    public ResponseEntity<PermisoResponseDTO> createPermiso(@RequestBody PermisoRequestDTO permiso){
        return new ResponseEntity<>(permisoService.createPermiso(permiso), HttpStatus.CREATED);
    }

    @GetMapping("/getAllPermisos")
    public ResponseEntity<List<PermisoResponseDTO>> getAllPermisos(){
        return new ResponseEntity<>(permisoService.getPermisos(), HttpStatus.OK);
    }

    @GetMapping("/getPermisoById/{permisoId}")
    public ResponseEntity<PermisoResponseDTO> getPermisoById(@PathVariable Long permisoId){
        return permisoService.getPermisoById(permisoId)
                .map(permiso -> new ResponseEntity<>(permiso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updatePermiso/{permisoId}")
    public ResponseEntity<PermisoResponseDTO> updatePermiso(@PathVariable Long permisoId,
                                                 @RequestBody PermisoRequestDTO permisoUpdate){
        return permisoService.updatePermisoById(permisoId, permisoUpdate)
                .map(permiso -> new ResponseEntity<>(permiso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deletePermisoById/{permisoId}")
    public ResponseEntity<Void> deletePermisoById(@PathVariable Long permisoId){
        if (permisoService.deletePermisoById(permisoId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
