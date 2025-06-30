package com.example.finca_hexagonal.domain.ports.in.Propietario;


import com.example.finca_hexagonal.domain.models.Propietario;

public interface UpdatePropietarioUseCase {
    Propietario update(Propietario propietario);
}
