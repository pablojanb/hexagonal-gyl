package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.out.PermisoModelPort;
import com.example.finca_hexagonal.infrastructure.entities.PermisoEntity;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import com.example.finca_hexagonal.infrastructure.mappers.PermisoMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaPermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoRepositoryAdapter implements PermisoModelPort {

    private final JpaPermisoRepository jpaPermisoRepository;
    private final PermisoMappers permisoMappers;

    public PermisoRepositoryAdapter(JpaPermisoRepository jpaPermisoRepository, PermisoMappers permisoMappers) {
        this.jpaPermisoRepository = jpaPermisoRepository;
        this.permisoMappers = permisoMappers;
    }

    @Override
    public Permiso save(Permiso permiso) {
        PermisoEntity permisoEntity = jpaPermisoRepository.save(permisoMappers.toEntity(permiso));
        return permisoMappers.toModel(permisoEntity);
    }

    @Override
    public List<Permiso> findAll() {
        List<PermisoEntity> permisoEntityList = jpaPermisoRepository.findAll();
        return permisoMappers.toModelList(permisoEntityList);
    }


    @Override
    public Permiso findById(Long id) {
        PermisoEntity permisoEntity = jpaPermisoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Error, Permiso no encontrado."));
        return permisoMappers.toModel(permisoEntity);
    }

    @Override
    public Permiso update(Permiso permiso) {
        PermisoEntity permisoEntity = permisoMappers.toEntity(findById(permiso.getId()));
        jpaPermisoRepository.save(permisoEntity);
        return permisoMappers.toModel(permisoEntity);
    }

    @Override
    public Boolean deleteById(Long id) {
        PermisoEntity permisoEntity = permisoMappers.toEntity(findById(id));
        jpaPermisoRepository.delete(permisoEntity);
        return true;
    }
}
