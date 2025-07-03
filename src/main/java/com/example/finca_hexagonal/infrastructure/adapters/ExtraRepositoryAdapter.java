package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Extra;
import com.example.finca_hexagonal.domain.ports.out.ExtraModelPort;
import com.example.finca_hexagonal.infrastructure.entities.ExtraEntity;
import com.example.finca_hexagonal.infrastructure.mappers.ExtraModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaExtraRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        if (jpaExtraRepository.existsById(id)){
            jpaExtraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Extra> findAll() {
        return jpaExtraRepository.findAll().stream()
                .map(extraModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Extra> findById(Long id) {
        return jpaExtraRepository.findById(id).map(extraModelMappers::toDomainModel);
    }

    @Override
    public Optional<Extra> updateById(Long id, Extra extraUpdate) {
        if (jpaExtraRepository.existsById(id)){
            ExtraEntity extraEntity = extraModelMappers.fromDomainModel(extraUpdate);
            ExtraEntity updateExtraEntity = jpaExtraRepository.save(extraEntity);
            return Optional.of(extraModelMappers.toDomainModel(updateExtraEntity));
        }
        return Optional.empty();
    }
}
