package com.example.finca_hexagonal.domain.ports.in.Reserva;

import com.example.finca_hexagonal.domain.models.Reserva;

public interface CreateReservasUseCase {
    Reserva create(Reserva reserva);
}
