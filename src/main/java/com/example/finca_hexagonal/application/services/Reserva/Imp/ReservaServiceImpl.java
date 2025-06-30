package com.example.finca_hexagonal.application.services.Reserva.Imp;

import com.example.finca_hexagonal.application.dto.reserva.ReservaRequestDTO;
import com.example.finca_hexagonal.application.dto.reserva.ReservaResponseDTO;
import com.example.finca_hexagonal.application.mappers.ReservaDTOMapper;
import com.example.finca_hexagonal.application.services.Reserva.ReservaService;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaModelService reservaModelService;
    private final ReservaDTOMapper reservaDTOMappers;

    public ReservaServiceImpl(ReservaModelService reservaModelService, ReservaDTOMapper reservaDTOMappers) {
        this.reservaModelService = reservaModelService;
        this.reservaDTOMappers = reservaDTOMappers;
    }

    @Override
    public ReservaResponseDTO create(ReservaRequestDTO reservaDto) {
        Reserva reserva = reservaDTOMappers.toModel(reservaDto);
        Reserva newReserva = reservaModelService.createReserva(reserva);
        return reservaDTOMappers.toDto(newReserva);
    }

    @Override
    public List<ReservaResponseDTO> getAll() {
        List<Reserva> reservas = reservaModelService.getAll(Pageable.unpaged()).getContent();
        return reservaDTOMappers.toDtoList(reservas);
    }

    @Override
    public Optional<ReservaResponseDTO> getById(Long reservaId) {
        Optional<Reserva> optionalReserva = reservaModelService.getById(reservaId);
        if (optionalReserva.isEmpty()) {
            throw new EntityNotFoundException("Reserva no encontrada: " + reservaId);
        }
        return Optional.of(reservaDTOMappers.toDto(optionalReserva.get()));
    }

    @Override
    public Optional<ReservaResponseDTO> updateById(Long reservaId, ReservaRequestDTO updateReservaDto) {
        Optional<Reserva> optionalReservaToUpdate = reservaModelService.getById(reservaId);
        if (optionalReservaToUpdate.isEmpty()) {
            throw new EntityNotFoundException("Reserva no encontrada: " + reservaId);
        }

        Reserva reservaToUpdate = optionalReservaToUpdate.get();
        Reserva newData = reservaDTOMappers.toModel(updateReservaDto);

        reservaToUpdate.setCliente(newData.getCliente());
        reservaToUpdate.setFinca(newData.getFinca());
        reservaToUpdate.setFecha(newData.getFecha());
        reservaToUpdate.setDesde(newData.getDesde());
        reservaToUpdate.setHasta(newData.getHasta());
        reservaToUpdate.setTotal(newData.getTotal());
        reservaToUpdate.setEstadoReserva(newData.getEstadoReserva());

        Optional<Reserva> updatedOptional = Optional.of(reservaModelService.update(reservaId, reservaToUpdate));
        return Optional.of(reservaDTOMappers.toDto(updatedOptional.get()));
    }

    @Override
    public boolean deleteById(Long reservaId) {
        return reservaModelService.delete(reservaId);
    }
}
