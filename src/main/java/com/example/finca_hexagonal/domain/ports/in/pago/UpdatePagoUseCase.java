package com.example.finca_hexagonal.domain.ports.in.pago;

import com.example.finca_hexagonal.domain.models.Pago;

import java.util.Optional;

public interface UpdatePagoUseCase {
    Optional<Pago> updatePago(Long pagoId, Pago UpdatePago);
}
