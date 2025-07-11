package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import com.example.finca_hexagonal.application.services.rol.RolService;
import com.example.finca_hexagonal.application.services.rol.impl.RolModelService;
import com.example.finca_hexagonal.domain.models.Rol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService){
        this.rolService = rolService;
    }

    @PostMapping
    public ResponseEntity<RolResponseDTO> createRol(@RequestBody RolRequestDTO rol){
        return new ResponseEntity<>(rolService.createRol(rol), HttpStatus.CREATED);
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<RolResponseDTO>> getAllRoles(){
        return new ResponseEntity<>(rolService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/getRolById/{rolId}")
    public ResponseEntity<RolResponseDTO> getRolById(@PathVariable Long rolId){
        return rolService.getRolById(rolId)
                .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateRol/{rolId}")
    public ResponseEntity<RolResponseDTO> updateRol(@PathVariable Long rolId,
                                         @RequestBody RolRequestDTO rolUpdate){
        return rolService.updateRolById(rolId, rolUpdate)
                .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteRolById/{rolId}")
    public ResponseEntity<Void> deleteFincaById(@PathVariable Long rolId){
        if (rolService.deleteRolById(rolId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addPermisoARol/{rolId}/{permisoId}")
    public ResponseEntity<RolResponseDTO> addPermisoARol(@PathVariable Long rolId,
                                                         @PathVariable Long permisoId){
        return rolService.addPermisoARol(rolId, permisoId)
                .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deletePermisoFromRol/{rolId}/{permisoId}")
    public ResponseEntity<RolResponseDTO> deletePermisoFromRol(@PathVariable Long rolId,
                                                         @PathVariable Long permisoId){
        return rolService.deletePermisoFromRol(rolId, permisoId)
                .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
