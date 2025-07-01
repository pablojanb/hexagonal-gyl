package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.extras.ExtraRequestDTO;
import com.example.finca_hexagonal.application.dto.extras.ExtraResponseDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaRequestDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTOSimplified;
import com.example.finca_hexagonal.application.services.Extra.ExtraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/extras")
public class ExtraController {

    private final ExtraService extraService;

    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @PostMapping
    public ResponseEntity<ExtraResponseDTO> createExtra(@RequestBody ExtraRequestDTO extraDTO){
        return new ResponseEntity<>(extraService.createExtra(extraDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllExtras")
    public ResponseEntity<List<ExtraResponseDTO>> getAllExtras(){
        return new ResponseEntity<>(extraService.getAllExtras(), HttpStatus.OK);
    }

    @GetMapping("/getExtraById/{extraId}")
    public ResponseEntity<ExtraResponseDTO> getFincaById(@PathVariable Long extraId){
        return extraService.getExtraById(extraId)
                .map(finca -> new ResponseEntity<>(finca, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteExtraById/{extraId}")
    public ResponseEntity<Void> deleteExtraById(@PathVariable Long extraId){
        if (extraService.deleteExtraById(extraId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
