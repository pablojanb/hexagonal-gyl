package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.ports.out.DireccionModelPort;
import com.example.finca_hexagonal.infrastructure.entities.DireccionEntity;
import com.example.finca_hexagonal.infrastructure.mappers.DireccionModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.DireccionJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DireccionRepositoryAdapter implements DireccionModelPort {
    private final DireccionJpaRepository direccionJpaRepository;
    private final DireccionModelMappers direccionModelMappers;

    public DireccionRepositoryAdapter(DireccionJpaRepository direccionJpaRepository, DireccionModelMappers direccionModelMappers) {
        this.direccionJpaRepository = direccionJpaRepository;
        this.direccionModelMappers = direccionModelMappers;
    }

    @Override
    public Direccion saveDireccion(Direccion direccion) {
        DireccionEntity direccionEntity = direccionModelMappers.fromDomainModel(direccion);
        DireccionEntity newDireccionEntity = direccionJpaRepository.save(direccionEntity);
        return direccionModelMappers.toDomainModel(newDireccionEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        if (direccionJpaRepository.existsById(id)){
            direccionJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Direccion> updateById(Long id, Direccion updateDireccion) {
        return Optional.empty();
    }

    @Override
    public List<Direccion> findAll() {
        return direccionJpaRepository.findAll().stream()
                .map(direccionModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Direccion> findById(Long id) {
        return direccionJpaRepository.findById(id).map(direccionModelMappers::toDomainModel);
    }
}
