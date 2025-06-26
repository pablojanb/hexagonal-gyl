package com.example.finca_hexagonal.domain.ports.in.pagos;

import com.example.finca_hexagonal.domain.models.Pago;

public interface UpdatePagoUseCase {
    Pago update(Pago pago);
}
