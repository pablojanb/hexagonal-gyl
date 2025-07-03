package com.example.finca_hexagonal.domain.ports.in.pago;

import com.example.finca_hexagonal.domain.models.Pago;

import java.util.List;
import java.util.Optional;

public interface GetPagoUseCase {
    List<Pago> getAllPago();

    Optional<Pago> getPagoById(Long pagoId);
}
