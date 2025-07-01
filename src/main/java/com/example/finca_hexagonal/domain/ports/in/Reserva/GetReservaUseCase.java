package com.example.finca_hexagonal.domain.ports.in.reserva;

import com.example.finca_hexagonal.domain.models.Reserva;

import java.util.List;
import java.util.Optional;

public interface GetReservaUseCase {
    List<Reserva> getAllReservas();

    Optional<Reserva> getReserva(Long reservaId);
}
