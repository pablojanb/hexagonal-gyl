package com.example.finca_hexagonal.application.services.Detalle;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import org.springframework.stereotype.Service;

@Service
public class DetalleModelService {
    public DetalleFinca getById(Long id) {
        return new DetalleFinca();
    }
}
