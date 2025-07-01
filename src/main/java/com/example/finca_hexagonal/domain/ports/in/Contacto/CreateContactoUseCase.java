package com.example.finca_hexagonal.domain.ports.in.Contacto;


import domain.models.Contacto;

public interface CreateContactoUseCase {
    Contacto create(Contacto contacto);
}
