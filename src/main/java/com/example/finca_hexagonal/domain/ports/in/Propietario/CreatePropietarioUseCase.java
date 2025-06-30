package com.example.finca_hexagonal.domain.ports.in.Propietario;


import com.example.finca_hexagonal.domain.models.Propietario;

public interface CreatePropietarioUseCase {
    Propietario create(Propietario propietario);

}
