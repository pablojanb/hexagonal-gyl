package com.example.finca_hexagonal.domain.ports.in.modoDePago;

import com.example.finca_hexagonal.domain.models.ModoDePago;

import java.util.Optional;

public interface UpdateModoDePagoUseCase {
    Optional<ModoDePago> updateById(Long id, ModoDePago modoDePago);
}
