package com.example.finca_hexagonal.application.usecases.reserva;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.in.Reserva.CreateReservaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ReservaModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateReservaUseCaseImpl implements CreateReservaUseCase {

    private final ReservaModelPort reservaModelPort;

    public CreateReservaUseCaseImpl(ReservaModelPort reservaModelPort) {
        this.reservaModelPort = reservaModelPort;
    }

    @Override
    public Reserva createReserva(Reserva reserva) {
        return reservaModelPort.save(reserva);
    }
}