package com.example.finca_hexagonal.domain.ports.in.Contacto;


import com.example.finca_hexagonal.domain.models.Propietario;

public interface DeleteContactoUseCase {
    Boolean delete(int id);

    Propietario logicalDeletion(Propietario propietario);
}
