package com.example.finca_hexagonal.domain.ports.in.direccion;

import com.example.finca_hexagonal.domain.models.Direccion;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UpdateDireccionUseCase {
    Optional<Direccion> updateDireccion(Long id, Direccion updateDireccion);
}
