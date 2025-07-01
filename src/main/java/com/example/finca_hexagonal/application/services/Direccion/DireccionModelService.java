package com.example.finca_hexagonal.application.services.Direccion;

import com.example.finca_hexagonal.domain.models.Direccion;
import org.springframework.stereotype.Service;


@Service
public class DireccionModelService {
    public Direccion getById(Long id) {
        return new Direccion(id, "Congresale 2332", "Bs as", 2323, "Buenos Aires", "Esto es una aclaracion");
    }
}
