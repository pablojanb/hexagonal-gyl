package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.recuperacionPassword.CambiarPasswordRequestDTO;
import com.example.finca_hexagonal.application.dto.recuperacionPassword.GenerarTokenRequestDTO;
import com.example.finca_hexagonal.application.services.recuperarPassword.RecuperarPasswordService;
import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recuperarPassword")
public class RecuperarPasswordController {

    @Autowired
    private RecuperarPasswordService recuperarPasswordService;

    @PostMapping("/crearToken")
    public ResponseEntity<RecuperarPassword> crearToken(@RequestBody GenerarTokenRequestDTO emailDto) throws MessagingException {
        RecuperarPassword recuperarPassword = recuperarPasswordService.crearToken(emailDto);
        return new ResponseEntity<>(recuperarPassword, HttpStatus.OK);
    }

    @PostMapping("/cambiarPassword")
    public ResponseEntity<RecuperarPassword> cambiarPassword(@RequestBody CambiarPasswordRequestDTO cambiarPasswordDTO){
        RecuperarPassword recuperarPassword = recuperarPasswordService.geTokenByEmail(cambiarPasswordDTO);
        return new ResponseEntity<>(recuperarPassword, HttpStatus.OK);
    }
}
