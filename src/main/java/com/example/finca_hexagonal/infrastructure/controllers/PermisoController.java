package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.services.permiso.impl.PermisoModelService;
import com.example.finca_hexagonal.domain.models.Permiso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    private final PermisoModelService permisoModelService;

    public PermisoController(PermisoModelService permisoModelService) {
        this.permisoModelService = permisoModelService;
    }

    @PostMapping
    public ResponseEntity<Permiso> createPermiso(@RequestBody Permiso permiso){
        return new ResponseEntity<>(permisoModelService.createPermiso(permiso), HttpStatus.CREATED);
    }

    @GetMapping("/getAllPermisos")
    public ResponseEntity<List<Permiso>> getAllPermisos(){
        return new ResponseEntity<>(permisoModelService.getAllPermisos(), HttpStatus.OK);
    }

    @GetMapping("/getPermisoById/{permisoId}")
    public ResponseEntity<Permiso> getPermisoById(@PathVariable Long permisoId){
        return permisoModelService.getPermiso(permisoId)
                .map(permiso -> new ResponseEntity<>(permiso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updatePermiso/{permisoId}")
    public ResponseEntity<Permiso> updatePermiso(@PathVariable Long permisoId,
                                                 @RequestBody Permiso permisoUpdate){
        return permisoModelService.updatePermiso(permisoId, permisoUpdate)
                .map(permiso -> new ResponseEntity<>(permiso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deletePermisoById/{permisoId}")
    public ResponseEntity<Void> deletePermisoById(@PathVariable Long permisoId){
        if (permisoModelService.deletePermiso(permisoId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
