package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.PagoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaPagoRepository extends JpaRepository<PagoEntity, Long> {

    @Query("SELECT p FROM PagoEntity p " +
            "WHERE (:estado_pagoBrowser IS NULL OR p.estadoPago = :estado_pagoBrowser) " +
            "AND (:idBrowser IS NULL OR p.reserva.id = :idBrowser)")
    Page<PagoEntity> filterPagoByParams(Pageable pageable,
                                        Boolean estado_pagoBrowser,
                                        Long idBrowser);

    List<PagoEntity> findByReservaId(Long reservaId);
}
