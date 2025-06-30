package com.example.finca_hexagonal.application.usecases.reserva;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.in.Reserva.DeleteReservaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ReservaModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteReservaUseCaseImpl implements DeleteReservaUseCase {

    private final ReservaModelPort reservaModelPort;

    public DeleteReservaUseCaseImpl(ReservaModelPort reservaModelPort) {
        this.reservaModelPort = reservaModelPort;
    }

    @Override
    public Boolean delete(Long id) {
        return reservaModelPort.delete(id);
    }

    @Override
    public Reserva logicalDeletion(Reserva reserva) {
        return reservaModelPort.logicalDeletion(reserva);
    }


}
