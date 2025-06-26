package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.services.HorarioService.impl.HorarioModelService;
import com.example.finca_hexagonal.domain.models.Horario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
    private final HorarioModelService horarioService;

    public HorarioController(HorarioModelService fincaService) {
        this.horarioService = fincaService;
    }


    @PostMapping
    public ResponseEntity<Horario> createHorario(Horario horario){
        return new ResponseEntity<>(horarioService.createHorario(horario), HttpStatus.CREATED);
    }

    @GetMapping("/getAllHorarios")
    public ResponseEntity<List<Horario>> getAllHorarios(){
        return new ResponseEntity<>(horarioService.getAllHorarios(), HttpStatus.OK);
    }

    @GetMapping("/getHorarioById/{horarioId}")
    public ResponseEntity<Horario> getHorarioById(@PathVariable Long horarioId){
        return horarioService.getHorarioById(horarioId)
                .map(horario -> new ResponseEntity<>(horario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateHorario/{horarioId}")
    public ResponseEntity<Horario> updateHorario(@PathVariable Long horarioId,
                                                 @RequestBody Horario horarioUpdate){
        return horarioService.updateHorario(horarioId, horarioUpdate)
                .map(horario -> new ResponseEntity<>(horario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteHorarioById/{horarioId}")
    public ResponseEntity<Void> deleteHorarioById(@PathVariable Long horarioId){
        if (horarioService.deleteHorario(horarioId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
