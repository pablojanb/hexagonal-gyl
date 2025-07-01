package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;
import com.example.finca_hexagonal.infrastructure.entities.PermisoEntity;
import com.example.finca_hexagonal.infrastructure.mappers.PermisoModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaPermisoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PermisoRepositoryAdapter implements PermisoModelPort {

    private final JpaPermisoRepository jpaPermisoRepository;
    private final PermisoModelMappers permisoModelMappers;

    public PermisoRepositoryAdapter(JpaPermisoRepository jpaPermisoRepository, PermisoModelMappers permisoModelMappers) {
        this.jpaPermisoRepository = jpaPermisoRepository;
        this.permisoModelMappers = permisoModelMappers;
    }

    @Override
    public Permiso save(Permiso permiso) {
        PermisoEntity permisoEntity = permisoModelMappers.fromDomainModel(permiso);
        PermisoEntity newPermisoEntity = jpaPermisoRepository.save(permisoEntity);
        return permisoModelMappers.toDomainModel(newPermisoEntity);
    }

    @Override
    public List<Permiso> findAll() {
        return jpaPermisoRepository.findAll().stream()
                .map(permisoModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Permiso> findById(Long id) {
        return jpaPermisoRepository.findById(id).map(permisoModelMappers::toDomainModel);
    }

    @Override
    public Optional<Permiso> updateById(Long id, Permiso updatePermiso) {
        if (jpaPermisoRepository.existsById(id)){
            PermisoEntity permisoEntity = permisoModelMappers.fromDomainModel(updatePermiso);
            permisoEntity.setId(id);
            PermisoEntity updateReservaEntity = jpaPermisoRepository.save(permisoEntity);
            return Optional.of(permisoModelMappers.toDomainModel(updateReservaEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaPermisoRepository.existsById(id)){
            jpaPermisoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
