package com.example.finca_hexagonal.domain.ports.in.fechaEspecial;


import org.springframework.stereotype.Service;

@Service
public interface DeleteFechaEspecialUseCase {
    boolean deleteFechaEspecial(Long id);
}
