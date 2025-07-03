package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.extras.ExtraRequestDTO;
import com.example.finca_hexagonal.application.dto.extras.ExtraResponseDTO;
import com.example.finca_hexagonal.application.services.extra.ExtraService;
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
    public ResponseEntity<ExtraResponseDTO> getExtraById(@PathVariable Long extraId){
        return extraService.getExtraById(extraId)
                .map(finca -> new ResponseEntity<>(finca, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateExtra/{extraId}")
    public ResponseEntity<ExtraResponseDTO> updateExtra(@PathVariable Long extraId,
                                                        @RequestBody ExtraRequestDTO extraUpdate){
        return extraService.updateExtraById(extraId, extraUpdate)
                .map(extra -> new ResponseEntity<>(extra, HttpStatus.OK))
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
