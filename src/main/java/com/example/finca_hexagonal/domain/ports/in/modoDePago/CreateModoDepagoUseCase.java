package com.example.finca_hexagonal.domain.ports.in.modoDePago;

import com.example.finca_hexagonal.domain.models.ModoDePago;

public interface CreateModoDepagoUseCase {
    ModoDePago save(ModoDePago modoDePago);
}
