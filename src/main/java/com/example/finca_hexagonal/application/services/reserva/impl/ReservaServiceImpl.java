package com.example.finca_hexagonal.application.services.reserva.impl;

import com.example.finca_hexagonal.application.dto.reservas.ReservaRequestDTO;
import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
import com.example.finca_hexagonal.application.mappers.ReservaDTOMapper;
import com.example.finca_hexagonal.application.services.reserva.ReservaService;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaModelService reservaModelService;
    private final ReservaDTOMapper reservaDTOMapper;

    public ReservaServiceImpl(ReservaModelService reservaModelService, ReservaDTOMapper reservaDTOMapper) {
        this.reservaModelService = reservaModelService;
        this.reservaDTOMapper = reservaDTOMapper;
    }

    @Override
    public ReservaResponseDTO create(ReservaRequestDTO reservaDto) {
        Reserva reserva = reservaDTOMapper.toModel(reservaDto);
        Reserva newReserva = reservaModelService.createReserva(reserva);
        return reservaDTOMapper.toDto(newReserva);
    }

    @Override
    public List<ReservaResponseDTO> getAll() {
        List<Reserva> reservas = reservaModelService.getAllReservas();
        return reservaDTOMapper.toDtoList(reservas);
    }

    @Override
    public Optional<ReservaResponseDTO> getById(Long reservaId) {
        Reserva reserva = reservaModelService.getReserva(reservaId)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada: " + reservaId));
        return Optional.of(reservaDTOMapper.toDto(reserva));
    }

    @Override
    public Optional<ReservaResponseDTO> updateById(Long reservaId, ReservaRequestDTO updateReservaDto) {
        Reserva reservaToUpdate = reservaModelService.getReserva(reservaId)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada: " + reservaId));
        Reserva newData = reservaDTOMapper.toModel(updateReservaDto);
        reservaToUpdate.setUsuario(newData.getUsuario());
        reservaToUpdate.setFinca(newData.getFinca());
        reservaToUpdate.setFecha(newData.getFecha());
        reservaToUpdate.setDesde(newData.getDesde());
        reservaToUpdate.setHasta(newData.getHasta());
        reservaToUpdate.setTotal(newData.getTotal());
        reservaToUpdate.setEstadoReserva(newData.getEstadoReserva());
        Reserva reservaUpdated = reservaModelService.updateReserva(reservaId, reservaToUpdate)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + reservaId));

        return Optional.of(reservaDTOMapper.toDto(reservaUpdated));
    }

    @Override
    public boolean deleteById(Long reservaId) {
        return reservaModelService.deleteReserva(reservaId);
    }
}
