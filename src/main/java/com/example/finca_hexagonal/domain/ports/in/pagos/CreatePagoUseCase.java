package com.example.finca_hexagonal.domain.ports.in.pagos;

import com.example.finca_hexagonal.domain.models.Pago;

public interface CreatePagoUseCase {
    Pago create(Pago pago);
}
