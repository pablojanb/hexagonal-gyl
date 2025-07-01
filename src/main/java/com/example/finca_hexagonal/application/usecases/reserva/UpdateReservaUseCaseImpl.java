package com.example.finca_hexagonal.application.usecases.reserva;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.in.reserva.UpdateReservaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ReservaModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateReservaUseCaseImpl implements UpdateReservaUseCase {

    private final ReservaModelPort reservaModelPort;

    public UpdateReservaUseCaseImpl(ReservaModelPort reservaModelPort) {
        this.reservaModelPort = reservaModelPort;
    }

    @Override
    public Optional<Reserva> updateReserva(Long reservaId, Reserva updateReserva) {
        return reservaModelPort.updateById(reservaId, updateReserva);
    }
}
