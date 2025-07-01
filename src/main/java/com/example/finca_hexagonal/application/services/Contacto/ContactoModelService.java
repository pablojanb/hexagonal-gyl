package com.example.finca_hexagonal.application.services.Contacto;

import com.example.finca_hexagonal.domain.models.Contacto;
import org.springframework.stereotype.Service;

@Service
public class ContactoModelService {
    public Contacto getById(Long contactoId) {
        return new Contacto();
    }
}
