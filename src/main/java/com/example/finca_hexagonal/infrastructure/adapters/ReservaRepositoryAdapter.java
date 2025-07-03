package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.out.ReservaModelPort;
import com.example.finca_hexagonal.infrastructure.entities.ReservaEntity;
import com.example.finca_hexagonal.infrastructure.mappers.ReservaModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaReservaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Reserva> findAll() {
        return jpaReservaRepository.findAll().stream()
                .map(reservaModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Reserva> findById(Long reservaId) {
        return jpaReservaRepository.findById(reservaId).map(reservaModelMappers::toDomainModel);
    }

    @Override
    public Optional<Reserva> updateById(Long reservaId, Reserva updateReserva) {
        if (jpaReservaRepository.existsById(reservaId)){
            ReservaEntity reservaEntity = reservaModelMappers.fromDomainModel(updateReserva);
            ReservaEntity updateReservaEntity = jpaReservaRepository.save(reservaEntity);
            return Optional.of(reservaModelMappers.toDomainModel(updateReservaEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long reservaId) {
        if (jpaReservaRepository.existsById(reservaId)){
            jpaReservaRepository.deleteById(reservaId);
            return true;
        }
        return false;
    }
}