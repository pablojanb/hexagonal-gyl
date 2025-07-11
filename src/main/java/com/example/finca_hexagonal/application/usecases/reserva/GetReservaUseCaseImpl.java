package com.example.finca_hexagonal.application.usecases.reserva;

import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.in.reserva.GetReservaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ReservaModelPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GetReservaUseCaseImpl implements GetReservaUseCase {

    private final ReservaModelPort reservaModelPort;

    public GetReservaUseCaseImpl(ReservaModelPort reservaModelPort) {
        this.reservaModelPort = reservaModelPort;
    }

    @Override
    public List<Reserva> getAllReservas() {
        return reservaModelPort.findAll();
    }

    @Override
    public Optional<Reserva> getReservaById(Long reservaId) {
        return reservaModelPort.findById(reservaId);
    }

    @Override
    public List<Reserva> getReservasByFincaIdAndFecha(Long fincaId, LocalDate fecha) {
        return reservaModelPort.findByFincaIdAndFecha(fincaId, fecha);
    }
}
