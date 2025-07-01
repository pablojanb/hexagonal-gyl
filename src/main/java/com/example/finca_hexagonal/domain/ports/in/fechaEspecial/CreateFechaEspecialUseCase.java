package com.example.finca_hexagonal.domain.ports.in.fechaEspecial;

import com.example.finca_hexagonal.domain.models.FechaEspecial;

public interface CreateFechaEspecialUseCase {

    FechaEspecial create(FechaEspecial fechaEspecial);
}
