package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.horarios.HorarioRequestDTO;
import com.example.finca_hexagonal.application.dto.horarios.HorarioResponseDTO;
import com.example.finca_hexagonal.application.services.horario.HorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
    private final HorarioService horarioService;
    public HorarioController(HorarioService fincaService) {
        this.horarioService = fincaService;
    }


    @PostMapping
    public ResponseEntity<HorarioResponseDTO> createHorario(@RequestBody HorarioRequestDTO horario){
        return new ResponseEntity<>(horarioService.createHorario(horario), HttpStatus.CREATED);
    }

    @GetMapping("/getAllHorarios")
    public ResponseEntity<List<HorarioResponseDTO>> getAllHorarios(){
        return new ResponseEntity<>(horarioService.getAllHorarios(), HttpStatus.OK);
    }

    @GetMapping("/getHorarioById/{horarioId}")
    public ResponseEntity<HorarioResponseDTO> getHorarioById(@PathVariable Long horarioId){
        return horarioService.getHorarioById(horarioId)
                .map(horario -> new ResponseEntity<>(horario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findAllHorariosByFincaId/{fincaId}")
    public ResponseEntity<List<HorarioResponseDTO>> findAllHorariosByFincaId(@PathVariable Long fincaId){
        return new ResponseEntity<>(horarioService.getAllHorariosByFincaId(fincaId), HttpStatus.OK);
    }

    @GetMapping("/findByFincaIdAndDiaSemana/{fincaId}/{diaSemana}")
    public ResponseEntity<List<HorarioResponseDTO>> findByFincaIdAndDiaSemana(@PathVariable Long fincaId,
                                                                              @PathVariable String diaSemana){
        return new ResponseEntity<>(horarioService.getAllHorariosByFincaIdAndDayOfWeek(fincaId, diaSemana), HttpStatus.OK);
    }

    @PutMapping("/updateHorario/{horarioId}")
    public ResponseEntity<HorarioResponseDTO> updateHorario(@PathVariable Long horarioId,
                                                 @RequestBody HorarioRequestDTO horarioUpdate){
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
