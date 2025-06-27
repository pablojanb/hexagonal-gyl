package com.example.finca_hexagonal.domain.ports.in.Reserva;

import com.example.finca_hexagonal.domain.models.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FindReservaUseCase {
    Page<Reserva> getAll(Pageable pageable);

    Optional<Reserva> getById(Long id);

    Page<Reserva> getByFincaId(Long fincaId,Pageable pageable);

    Page<Reserva> getByClienteId(Long clienteId,Pageable pageable);

    Page<Reserva> getByEstadoReserva(Boolean estadoReserva, Pageable pageable);

    Page<Reserva> filterReservaByReservaParams(Pageable pageable,
                                               Long clienteIdBrowser,
                                               Long FincaIdBrowser,
                                               Boolean estadoReservaBrowser);
}
