package com.example.finca_hexagonal.domain.ports.in.Reserva;

import com.example.finca_hexagonal.domain.models.Reserva;

public interface DeleteReservaUseCase {
    Boolean delete(Long id);
    Reserva logicalDeletion(Reserva reserva);
}
