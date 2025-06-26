package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;
import com.example.finca_hexagonal.infrastructure.entities.PermisoEntity;
import com.example.finca_hexagonal.infrastructure.mappers.PermisoMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaPermisoRepository;

import java.util.List;
import java.util.Optional;

public class PermisoRepositoryAdapter implements PermisoModelPort {

    private final JpaPermisoRepository jpaPermisoRepository;
    private final PermisoMappers permisoMappers;

    public PermisoRepositoryAdapter(JpaPermisoRepository jpaPermisoRepository, PermisoMappers permisoMappers) {
        this.jpaPermisoRepository = jpaPermisoRepository;
        this.permisoMappers = permisoMappers;
    }

    @Override
    public Permiso save(Permiso permiso) {
        PermisoEntity permisoEntity = permisoMappers.toEntity(permiso);
        jpaPermisoRepository.save(permisoEntity);
        return permisoMappers.toModel(permisoEntity);
    }

    @Override
    public List<Permiso> findAll() {
        return List.of();
    }

    @Override
    public Optional<Permiso> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Permiso update(Permiso permiso) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }
}
