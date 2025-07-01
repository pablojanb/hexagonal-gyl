package com.example.finca_hexagonal.application.usecases.reserva;

import com.example.finca_hexagonal.domain.ports.in.reserva.DeleteReservaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ReservaModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteReservaUseCaseImpl implements DeleteReservaUseCase {

    private final ReservaModelPort reservaModelPort;

    public DeleteReservaUseCaseImpl(ReservaModelPort reservaModelPort) {
        this.reservaModelPort = reservaModelPort;
    }

    @Override
    public boolean deleteReserva(Long reservaId) {
        return reservaModelPort.deleteById(reservaId);
    }
}
