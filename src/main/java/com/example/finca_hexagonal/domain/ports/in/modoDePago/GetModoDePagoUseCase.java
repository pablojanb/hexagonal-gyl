package com.example.finca_hexagonal.domain.ports.in.modoDePago;

import com.example.finca_hexagonal.domain.models.ModoDePago;

import java.util.List;
import java.util.Optional;

public interface GetModoDePagoUseCase {
    Optional<ModoDePago> getById(Long id);
    List<ModoDePago> getAll();
}
