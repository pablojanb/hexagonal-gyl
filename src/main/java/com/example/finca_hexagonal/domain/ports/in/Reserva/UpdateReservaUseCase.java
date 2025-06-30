package com.example.finca_hexagonal.domain.ports.in.Reserva;

import com.example.finca_hexagonal.domain.models.Reserva;

public interface UpdateReservaUseCase {
    Reserva update(Long reservaId, Reserva reserva);

}
