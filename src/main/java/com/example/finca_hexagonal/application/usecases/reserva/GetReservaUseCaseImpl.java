package com.example.finca_hexagonal.application.usecases.reserva;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.in.Reserva.FindReservaUseCase;
import com.example.finca_hexagonal.domain.ports.out.ReservaModelPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetReservaUseCaseImpl implements FindReservaUseCase {

    private final ReservaModelPort reservaModelPort;

    public GetReservaUseCaseImpl(ReservaModelPort reservaModelPort) {
        this.reservaModelPort = reservaModelPort;
    }

    @Override
    public Page<Reserva> getAll(Pageable pageable) {
        return reservaModelPort.findAll(pageable);
    }

    @Override
    public Optional<Reserva> getById(Long id) {
        return reservaModelPort.findById(id);
    }

    @Override
    public Page<Reserva> getByFincaId(Long fincaId, Pageable pageable) {
        return reservaModelPort.findByFincaId(fincaId, pageable);
    }

    @Override
    public Page<Reserva> getByClienteId(Long clienteId, Pageable pageable) {
        return reservaModelPort.findByClienteId(clienteId, pageable);
    }

    @Override
    public Page<Reserva> getByEstadoReserva(Boolean estadoReserva, Pageable pageable) {
        return reservaModelPort.findByEstadoReserva(estadoReserva, pageable);
    }

    @Override
    public Page<Reserva> filterReservaByReservaParams(Pageable pageable, Long clienteIdBrowser, Long fincaIdBrowser, Boolean estadoReservaBrowser) {
        return reservaModelPort.filterReservaByReservaParams(pageable, clienteIdBrowser, fincaIdBrowser, estadoReservaBrowser);
    }
}
