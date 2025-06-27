package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReservaModelPort {
    Reserva save(Reserva reserva);

    Page<Reserva> findAll(Pageable pageable);

    Optional<Reserva> findById(Long id);

    Page<Reserva> findByFincaId(Long fincaId,Pageable pageable);

    Page<Reserva> findByClienteId(Long clienteId,Pageable pageable);

    Page<Reserva> findByEstadoReserva(Boolean estadoReserva, Pageable pageable);

    Page<Reserva> filterReservaByReservaParams(Pageable pageable,
                                               Long clienteIdBrowser,
                                               Long FincaIdBrowser,
                                               Boolean estadoReservaBrowser);

    Reserva update(Reserva reserva);

    Boolean delete(Long id);
    Reserva logicalDeletion(Reserva reserva);
}
