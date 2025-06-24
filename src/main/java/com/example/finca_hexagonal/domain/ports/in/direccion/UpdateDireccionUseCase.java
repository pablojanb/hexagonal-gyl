package com.example.finca_hexagonal.domain.ports.in.direccion;

import com.example.finca_hexagonal.domain.models.Direccion;

public interface UpdateDireccionUseCase {
    Direccion update(Direccion direccion);

}
