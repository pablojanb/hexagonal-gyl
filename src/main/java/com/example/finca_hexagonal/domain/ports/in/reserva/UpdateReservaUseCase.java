package com.example.finca_hexagonal.domain.ports.in.reserva;

import com.example.finca_hexagonal.domain.models.Reserva;

import java.util.Optional;

public interface UpdateReservaUseCase {

    Optional<Reserva> updateReserva(Long reservaId, Reserva updateReserva);
}