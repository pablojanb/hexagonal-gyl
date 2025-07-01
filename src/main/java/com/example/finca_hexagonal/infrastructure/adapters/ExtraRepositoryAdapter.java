package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Extra;
import com.example.finca_hexagonal.domain.ports.out.ExtraModelPort;
import com.example.finca_hexagonal.infrastructure.entities.ExtraEntity;
import com.example.finca_hexagonal.infrastructure.mappers.ExtraModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaExtraRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ExtraRepositoryAdapter implements ExtraModelPort {
    private final JpaExtraRepository jpaExtraRepository;
    private final ExtraModelMappers extraModelMappers;

    public ExtraRepositoryAdapter(JpaExtraRepository jpaExtraRepository, ExtraModelMappers extraModelMappers) {
        this.jpaExtraRepository = jpaExtraRepository;
        this.extraModelMappers = extraModelMappers;
    }

    @Override
    public Extra save(Extra extra) {
        ExtraEntity extraEntity = extraModelMappers.fromDomainModel(extra);
        ExtraEntity newExtraEntity = jpaExtraRepository.save(extraEntity);
        return extraModelMappers.toDomainModel(newExtraEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Extra> findAll() {
        return List.of();
    }

    @Override
    public Optional<Extra> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Extra> updateById(Long id, Extra extraUpdate) {
        return Optional.empty();
    }
}
