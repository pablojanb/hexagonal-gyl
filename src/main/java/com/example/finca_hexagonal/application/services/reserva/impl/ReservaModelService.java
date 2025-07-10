package com.example.finca_hexagonal.application.services.reserva.impl;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.in.reserva.CreateReservaUseCase;
import com.example.finca_hexagonal.domain.ports.in.reserva.DeleteReservaUseCase;
import com.example.finca_hexagonal.domain.ports.in.reserva.GetReservaUseCase;
import com.example.finca_hexagonal.domain.ports.in.reserva.UpdateReservaUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaModelService implements CreateReservaUseCase, GetReservaUseCase, UpdateReservaUseCase, DeleteReservaUseCase {

    private final CreateReservaUseCase createReservaUseCase;
    private final GetReservaUseCase getReservaUseCase;
    private final UpdateReservaUseCase updateReservaUseCase;
    private final DeleteReservaUseCase deleteReservaUseCase;

    public ReservaModelService(CreateReservaUseCase createReservaUseCase, GetReservaUseCase getReservaUseCase, UpdateReservaUseCase updateReservaUseCase, DeleteReservaUseCase deleteReservaUseCase){
        this.createReservaUseCase = createReservaUseCase;
        this.getReservaUseCase = getReservaUseCase;
        this.updateReservaUseCase = updateReservaUseCase;
        this.deleteReservaUseCase = deleteReservaUseCase;
    }

    @Override
    public Reserva createReserva(Reserva reserva) {
        return createReservaUseCase.createReserva(reserva);
    }

    @Override
    public boolean deleteReserva(Long reservaId) {
        return deleteReservaUseCase.deleteReserva(reservaId);
    }

    @Override
    public List<Reserva> getAllReservas() {
        return getReservaUseCase.getAllReservas();
    }

    @Override
    public Optional<Reserva> getReservaById(Long reservaId) {
        return getReservaUseCase.getReservaById(reservaId);
    }

    @Override
    public Optional<Reserva> updateReserva(Long reservaId, Reserva updateReserva) {
        return updateReservaUseCase.updateReserva(reservaId, updateReserva);
    }

    public BigDecimal calcularTotalReserva(Reserva reserva) {
        if (reserva.getDesde() != null && reserva.getHasta() != null) {
            long horas = java.time.Duration.between(reserva.getDesde(), reserva.getHasta()).toHours();
            if (horas < 1) horas = 1;
            return reserva.getFinca().getTarifaHora().multiply(BigDecimal.valueOf(horas));
        } else {
            return BigDecimal.ZERO;
        }
    }
}
