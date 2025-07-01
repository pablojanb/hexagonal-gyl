package com.example.finca_hexagonal.domain.ports.in.reserva;

import com.example.finca_hexagonal.domain.models.Reserva;

public interface CreateReservaUseCase {
    Reserva createReserva(Reserva reserva);
}
