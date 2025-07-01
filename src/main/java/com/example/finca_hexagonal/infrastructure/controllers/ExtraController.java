package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.extras.ExtraRequestDTO;
import com.example.finca_hexagonal.application.dto.extras.ExtraResponseDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaRequestDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTOSimplified;
import com.example.finca_hexagonal.application.services.Extra.ExtraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
