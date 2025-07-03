package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.ports.out.DireccionModelPort;
import com.example.finca_hexagonal.infrastructure.entities.DireccionEntity;
import com.example.finca_hexagonal.infrastructure.mappers.DireccionModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaDireccionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DireccionRepositoryAdapter implements DireccionModelPort {
    private final JpaDireccionRepository jpaDireccionRepository;
    private final DireccionModelMappers direccionModelMappers;

    public DireccionRepositoryAdapter(JpaDireccionRepository jpaDireccionRepository, DireccionModelMappers direccionModelMappers) {
        this.jpaDireccionRepository = jpaDireccionRepository;
        this.direccionModelMappers = direccionModelMappers;
    }

    @Override
    public Direccion saveDireccion(Direccion direccion) {
        DireccionEntity direccionEntity = direccionModelMappers.fromDomainModel(direccion);
        DireccionEntity newDireccionEntity = jpaDireccionRepository.save(direccionEntity);
        return direccionModelMappers.toDomainModel(newDireccionEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaDireccionRepository.existsById(id)){
            jpaDireccionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Direccion> updateById(Long id, Direccion updateDireccion) {
        if (jpaDireccionRepository.existsById(id)){
            DireccionEntity direccionEntity = direccionModelMappers.fromDomainModel(updateDireccion);
            DireccionEntity updateDireccionEntity = jpaDireccionRepository.save(direccionEntity);
            return Optional.of(direccionModelMappers.toDomainModel(updateDireccionEntity));
        }
        return Optional.empty();
    }

    @Override
    public List<Direccion> findAll() {
        return jpaDireccionRepository.findAll().stream()
                .map(direccionModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Direccion> findById(Long id) {
        return jpaDireccionRepository.findById(id).map(direccionModelMappers::toDomainModel);
    }
}
