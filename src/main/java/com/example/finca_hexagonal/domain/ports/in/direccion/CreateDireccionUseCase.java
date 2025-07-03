package com.example.finca_hexagonal.domain.ports.in.direccion;

import com.example.finca_hexagonal.domain.models.Direccion;
import org.springframework.stereotype.Service;

@Service
public interface CreateDireccionUseCase {
    Direccion createDireccion(Direccion direccion);
}
