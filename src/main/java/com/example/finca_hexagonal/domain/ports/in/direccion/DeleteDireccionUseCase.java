package com.example.finca_hexagonal.domain.ports.in.direccion;

import org.springframework.stereotype.Service;

@Service
public interface DeleteDireccionUseCase {
    boolean deleteDireccion(Long id);
}
