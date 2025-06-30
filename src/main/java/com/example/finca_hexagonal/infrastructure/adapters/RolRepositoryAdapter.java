package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.out.RolModelPort;
import com.example.finca_hexagonal.infrastructure.entities.RolEntity;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import com.example.finca_hexagonal.infrastructure.mappers.RolMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaRolRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RolRepositoryAdapter implements RolModelPort {

    private final JpaRolRepository jpaRolRepository;
    private final RolMappers rolMappers;

    public RolRepositoryAdapter(JpaRolRepository jpaRolRepository, RolMappers rolMappers) {
        this.jpaRolRepository = jpaRolRepository;
        this.rolMappers = rolMappers;
    }

    @Override
    public Rol save(Rol rol) {
        RolEntity rolEntity = jpaRolRepository.save(rolMappers.toEntity(rol));
        return rolMappers.toModel(rolEntity);
    }

    @Override
    public List<Rol> findAll() {
        return rolMappers.toModelList(jpaRolRepository.findAll());
    }

    @Override
    public Rol findById(Long id) {
        RolEntity rolEntity = jpaRolRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Error, rol con id: "+id+" no encontrado"));
        return rolMappers.toModel(rolEntity);
    }

    @Override
    public Rol findByName(String nombre) {
        RolEntity rolEntity = jpaRolRepository.findRolEntityByNombre(nombre)
                .orElseThrow(()-> new EntityNotFoundException("Error, rol con nombre: "+nombre+" no encontrado"));

        return rolMappers.toModel(rolEntity);
    }

    @Override
    public Rol update(Rol rol) {
        RolEntity rolEntity = jpaRolRepository.save(rolMappers.toEntity(rol));
        return rolMappers.toModel(rolEntity);
    }

    @Override
    public Boolean deleteById(Long id) {
        Rol rol = findById(id);
        jpaRolRepository.delete(rolMappers.toEntity(rol));
        return true;
    }

    @Override
    public Rol logicalDeletion(Rol rol) {
        RolEntity rolEntity = jpaRolRepository.save(rolMappers.toEntity(rol));
        return rolMappers.toModel(rolEntity);
    }
}
