package com.example.finca_hexagonal.domain.ports.in.ModoDePago;

import com.example.finca_hexagonal.domain.models.ModoDePago;

public interface DeleteModoDePagoUseCase {
    ModoDePago delete(Long id);

    ModoDePago LogicalDeletion(ModoDePago modoDePago);
}
