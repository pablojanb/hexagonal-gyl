package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.application.mappers.RolDTOMapper;
import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.out.RolModelPort;
import com.example.finca_hexagonal.infrastructure.repositories.JpaRolRepository;

import java.util.List;
import java.util.Optional;

public class RolRepositoryAdapter implements RolModelPort {

    private final JpaRolRepository jpaRolRepository;
    private final RolDTOMapper rolDTOMapper;

    public RolRepositoryAdapter(JpaRolRepository jpaRolRepository, RolDTOMapper rolDTOMapper) {
        this.jpaRolRepository = jpaRolRepository;
        this.rolDTOMapper = rolDTOMapper;
    }

    @Override
    public Rol save(Rol rol) {
        return null;
    }

    @Override
    public List<Rol> findAll() {
        return List.of();
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Rol> findByName(String nombre) {
        return Optional.empty();
    }

    @Override
    public Rol update(Rol rol) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public Rol logicalDeletion(Rol rol) {
        return null;
    }
}
