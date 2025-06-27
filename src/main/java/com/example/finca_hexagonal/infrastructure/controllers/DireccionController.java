package com.example.finca_hexagonal.infrastructure.controllers;


import com.example.finca_hexagonal.application.services.direccion.DireccionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course_users")
//@Tag(name = "Direccion", description = "Controller for Direccion")
public class DireccionController {
    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

}

