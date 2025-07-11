package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
import com.example.finca_hexagonal.domain.models.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaModelPort {
    Reserva save(Reserva reserva);

    List<Reserva> findAll();

    Optional<Reserva> findById(Long reservaId);

    Optional<Reserva> updateById(Long reservaId, Reserva updateReserva);

    boolean deleteById(Long reservaId);

    List<Reserva> findByFincaIdAndFecha(Long fincaId, LocalDate fecha);
}
