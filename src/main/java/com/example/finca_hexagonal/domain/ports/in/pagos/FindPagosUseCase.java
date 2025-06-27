package com.example.finca_hexagonal.domain.ports.in.pagos;

import com.example.finca_hexagonal.domain.models.Pago;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface FindPagosUseCase {
    Page<Pago> getAll(Pageable pageable);

    Optional<Pago> getById(Long id);

   Page<Pago> filterPagoByParams(Pageable pageable,
                                 Boolean estado_pagoBrowser,
                                 Long idBrowser);

   List<Pago> getByReservaId (Long reserva_id);
}
