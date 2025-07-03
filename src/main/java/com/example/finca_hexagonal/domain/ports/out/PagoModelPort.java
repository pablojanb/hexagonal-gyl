package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Pago;

import java.util.List;
import java.util.Optional;

public interface PagoModelPort {
    Pago save(Pago pago);

    List<Pago> FindAll();

    Optional<Pago> findBYId(Long pagoId);

    Optional<Pago> updateById(Long pagoId, Pago updatePago);

    Boolean deletedById(Long pagoId);
}
