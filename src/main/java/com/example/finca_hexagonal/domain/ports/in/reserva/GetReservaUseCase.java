package com.example.finca_hexagonal.domain.ports.in.reserva;

import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
import com.example.finca_hexagonal.domain.models.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GetReservaUseCase {
    List<Reserva> getAllReservas();

    Optional<Reserva> getReservaById(Long reservaId);

    List<Reserva> getReservasByFincaIdAndFecha(Long fincaId, LocalDate fecha);
}
