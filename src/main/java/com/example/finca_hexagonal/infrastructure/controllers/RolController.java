package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.services.rol.impl.RolModelService;
import com.example.finca_hexagonal.domain.models.Rol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolModelService rolModelService;

    public RolController(RolModelService rolModelService){
        this.rolModelService = rolModelService;
    }

    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol){
        return new ResponseEntity<>(rolModelService.createRol(rol), HttpStatus.CREATED);
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<Rol>> getAllRoles(){
        return new ResponseEntity<>(rolModelService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/getRolById/{rolId}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long rolId){
        return rolModelService.getRol(rolId)
                .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateRol/{rolId}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long rolId,
                                         @RequestBody Rol rolUpdate){
        return rolModelService.updateRol(rolId, rolUpdate)
                .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteRolById/{rolId}")
    public ResponseEntity<Void> deleteFincaById(@PathVariable Long rolId){
        if (rolModelService.deleteRol(rolId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
