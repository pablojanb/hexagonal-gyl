package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.out.ReservaModelPort;
import com.example.finca_hexagonal.infrastructure.entities.ReservaEntity;
import com.example.finca_hexagonal.infrastructure.mappers.ReservaModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaReservaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReservaRepositoryAdapter implements ReservaModelPort {

    private final JpaReservaRepository jpaReservaRepository;
    private final ReservaModelMappers reservaModelMappers;

    public ReservaRepositoryAdapter(JpaReservaRepository jpaReservaRepository, ReservaModelMappers reservaModelMappers) {
        this.jpaReservaRepository = jpaReservaRepository;
        this.reservaModelMappers = reservaModelMappers;
    }

    @Override
    public Reserva save(Reserva reserva) {
        ReservaEntity reservaEntity = reservaModelMappers.fromDomainModel(reserva);
        ReservaEntity newReservaEntity = jpaReservaRepository.save(reservaEntity);
        return reservaModelMappers.toDomainModel(newReservaEntity);
    }

    @Override
    public Page<Reserva> findAll(Pageable pageable) {
        return jpaReservaRepository.findAll(pageable)
                .map(reservaModelMappers::toDomainModel);
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return jpaReservaRepository.findById(id)
                .map(reservaModelMappers::toDomainModel);
    }

    @Override
    public Page<Reserva> findByFincaId(Long fincaId, Pageable pageable) {
        return jpaReservaRepository.findByFincaId(fincaId, pageable)
                .map(reservaModelMappers::toDomainModel);
    }

    @Override
    public Page<Reserva> findByClienteId(Long clienteId, Pageable pageable) {
        return jpaReservaRepository.findByClienteId(clienteId, pageable)
                .map(reservaModelMappers::toDomainModel);
    }

    @Override
    public Page<Reserva> findByEstadoReserva(Boolean estadoReserva, Pageable pageable) {
        return jpaReservaRepository.findByEstadoReserva(estadoReserva, pageable)
                .map(reservaModelMappers::toDomainModel);
    }

    @Override
    public Page<Reserva> filterReservaByReservaParams(Pageable pageable, Long clienteIdBrowser, Long fincaIdBrowser, Boolean estadoReservaBrowser) {
        return jpaReservaRepository.filterReservaByReservaParams(pageable, clienteIdBrowser, fincaIdBrowser, estadoReservaBrowser)
                .map(reservaModelMappers::toDomainModel);
    }

    @Override
    public Reserva update(Reserva reserva) {
        return save(reserva); // Actualiza si ya existe, o crea si no
    }

    @Override
    public Boolean delete(Long id) {
        if (jpaReservaRepository.existsById(id)) {
            jpaReservaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Reserva logicalDeletion(Reserva reserva) {
        reserva.setEstadoReserva(false); // Asumiendo que false significa "eliminado"
        return save(reserva);
    }
}
