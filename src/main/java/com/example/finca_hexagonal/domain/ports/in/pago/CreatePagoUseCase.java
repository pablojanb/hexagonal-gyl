package com.example.finca_hexagonal.domain.ports.in.pago;

import com.example.finca_hexagonal.domain.models.Pago;

public interface CreatePagoUseCase {
    Pago save(Pago pago);
}
