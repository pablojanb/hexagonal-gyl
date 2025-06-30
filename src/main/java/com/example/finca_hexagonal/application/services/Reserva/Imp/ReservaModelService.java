package com.example.finca_hexagonal.application.services.Reserva.Imp;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.in.Reserva.CreateReservaUseCase;
import com.example.finca_hexagonal.domain.ports.in.Reserva.DeleteReservaUseCase;
import com.example.finca_hexagonal.domain.ports.in.Reserva.FindReservaUseCase;
import com.example.finca_hexagonal.domain.ports.in.Reserva.UpdateReservaUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaModelService implements CreateReservaUseCase,
        FindReservaUseCase,
        DeleteReservaUseCase,
        UpdateReservaUseCase {

    private final CreateReservaUseCase createReservaUseCase;
    private final FindReservaUseCase findReservaUseCase;
    private final UpdateReservaUseCase updateReservaUseCase;
    private final DeleteReservaUseCase deleteReservaUseCase;

    public ReservaModelService(CreateReservaUseCase createReservaUseCase,
                               FindReservaUseCase findReservaUseCase,
                               UpdateReservaUseCase updateReservaUseCase,
                               DeleteReservaUseCase deleteReservaUseCase) {
        this.createReservaUseCase = createReservaUseCase;
        this.findReservaUseCase = findReservaUseCase;
        this.updateReservaUseCase = updateReservaUseCase;
        this.deleteReservaUseCase = deleteReservaUseCase;
    }

    @Override
    public Reserva createReserva(Reserva reserva) {
        return createReservaUseCase.createReserva(reserva);
    }

    @Override
    public Boolean delete(Long id) {
        return deleteReservaUseCase.delete(id);
    }

    @Override
    public Reserva logicalDeletion(Reserva reserva) {
        return deleteReservaUseCase.logicalDeletion(reserva);
    }

    @Override
    public Page<Reserva> getAll(Pageable pageable) {
        return findReservaUseCase.getAll(pageable);
    }

    @Override
    public Optional<Reserva> getById(Long id) {
        return findReservaUseCase.getById(id);
    }

    @Override
    public Page<Reserva> getByFincaId(Long fincaId, Pageable pageable) {
        return findReservaUseCase.getByFincaId(fincaId, pageable);
    }

    @Override
    public Page<Reserva> getByClienteId(Long clienteId, Pageable pageable) {
        return findReservaUseCase.getByClienteId(clienteId, pageable);
    }

    @Override
    public Page<Reserva> getByEstadoReserva(Boolean estadoReserva, Pageable pageable) {
        return findReservaUseCase.getByEstadoReserva(estadoReserva, pageable);
    }

    @Override
    public Page<Reserva> filterReservaByReservaParams(Pageable pageable, Long clienteIdBrowser, Long fincaIdBrowser, Boolean estadoReservaBrowser) {
        return findReservaUseCase.filterReservaByReservaParams(pageable, clienteIdBrowser, fincaIdBrowser, estadoReservaBrowser);
    }

    @Override
    public Reserva update(Long reservaId, Reserva reserva) {
        return updateReservaUseCase.update(reservaId, reserva);
    }
}
