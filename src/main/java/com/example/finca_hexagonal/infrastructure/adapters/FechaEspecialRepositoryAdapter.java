package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.ports.out.FechaEspecialModelPort;
import com.example.finca_hexagonal.infrastructure.entities.FechaEspecialEntity;
import com.example.finca_hexagonal.infrastructure.mappers.FechaEspecialModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaFechaEspecialRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FechaEspecialRepositoryAdapter implements FechaEspecialModelPort {
    private final JpaFechaEspecialRepository jpaFechaEspecialRepository;
    private final FechaEspecialModelMappers fechaEspecialMappers;


    public FechaEspecialRepositoryAdapter(JpaFechaEspecialRepository jpaFechaEspecialRepository, FechaEspecialModelMappers fechaEspecialMappers, FechaEspecialModelMappers fechaEspecialModelMappers) {
        this.jpaFechaEspecialRepository = jpaFechaEspecialRepository;
        this.fechaEspecialMappers = fechaEspecialMappers;
    }

    @Override
    public FechaEspecial create(FechaEspecial fechaEspecial){
        FechaEspecialEntity fechaEspecialEntity = fechaEspecialMappers.fromDomainModel(fechaEspecial);
        FechaEspecialEntity newFechaEspecialEntity = jpaFechaEspecialRepository.save(fechaEspecialEntity);
        return fechaEspecialMappers.toDomainModel(newFechaEspecialEntity);
    }

    @Override
    public boolean deleteFechaEspecial(Long id) {
        if(jpaFechaEspecialRepository.existsById(id)){
            jpaFechaEspecialRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<FechaEspecial> getAll() {
        return jpaFechaEspecialRepository.findAll().stream()
                .map(fechaEspecialMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FechaEspecial> getById(Long id) {
        return jpaFechaEspecialRepository.findById(id).map(fechaEspecialMappers::toDomainModel);
    }

    @Override
    public Optional<FechaEspecial> update(Long id, FechaEspecial fechaEspecial) {
        if(jpaFechaEspecialRepository.existsById(id)){
            FechaEspecialEntity fechaEspecialEntity = fechaEspecialMappers.fromDomainModel(fechaEspecial);
            FechaEspecialEntity updateFechaEspecialEntity = jpaFechaEspecialRepository.save(fechaEspecialEntity);
            return Optional.of(fechaEspecialMappers.toDomainModel(updateFechaEspecialEntity));
        }
        return Optional.empty();
    }

    @Override
    public List<FechaEspecial> findAllFechaEspecialByFincaId(Long id) {
        return jpaFechaEspecialRepository.findByFincaId(id).stream()
                .map(fechaEspecialMappers::toDomainModel)
                .collect(Collectors.toList());
    }
}
