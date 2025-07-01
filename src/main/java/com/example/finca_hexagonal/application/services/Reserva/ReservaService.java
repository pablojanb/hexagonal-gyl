package com.example.finca_hexagonal.application.services.Reserva;


import com.example.finca_hexagonal.application.dto.reservas.ReservaRequestDTO;
import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    ReservaResponseDTO create(ReservaRequestDTO reservaDto);

    List<ReservaResponseDTO> getAll();

    Optional<ReservaResponseDTO> getById(Long reservaId);

    Optional<ReservaResponseDTO> updateById(Long reservaId, ReservaRequestDTO updateReservaDto);

    boolean deleteById(Long reservaId);
}
