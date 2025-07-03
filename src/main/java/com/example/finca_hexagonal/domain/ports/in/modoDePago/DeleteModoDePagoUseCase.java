package com.example.finca_hexagonal.domain.ports.in.modoDePago;

import com.example.finca_hexagonal.domain.models.ModoDePago;

import java.util.Optional;

public interface DeleteModoDePagoUseCase {
boolean deleteById(Long id);
}
