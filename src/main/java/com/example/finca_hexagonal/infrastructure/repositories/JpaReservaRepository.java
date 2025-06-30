package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.ReservaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaReservaRepository extends JpaRepository<ReservaEntity, Long> {

    Page<ReservaEntity> findByFincaId(Long fincaId, Pageable pageable);

    Page<ReservaEntity> findByClienteId(Long clienteId, Pageable pageable);

    Page<ReservaEntity> findByEstadoReserva(Boolean estadoReserva, Pageable pageable);

    @Query("SELECT r FROM ReservaEntity r " +
            "WHERE (:clienteId IS NULL OR r.clienteId = :clienteId) " +
            "AND (:fincaId IS NULL OR r.fincaId = :fincaId) " +
            "AND (:estadoReserva IS NULL OR r.estadoReserva = :estadoReserva)")
    Page<ReservaEntity> filterReservaByReservaParams(Pageable pageable,
                                                     @Param("clienteId") Long clienteId,
                                                     @Param("fincaId") Long fincaId,
                                                     @Param("estadoReserva") Boolean estadoReserva);
}
