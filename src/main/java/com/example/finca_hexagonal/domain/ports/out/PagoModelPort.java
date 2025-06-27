package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Pago;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface PagoModelPort {
    Pago save(Pago pago);

    Page<Pago> findAll(Pageable pageable);

    Optional<Pago> findId(Long id);

    Page<Pago> filterPagoByParams(Pageable pageable,
                                  Boolean estado_pagoBrowser,
                                  Long idBrowser);

    List<Pago> findByReservaId (Long reserva_id);

    Pago update(Pago pago);

    Boolean delete (Long id);

    Pago logicalDeletion (Pago pago);

}
