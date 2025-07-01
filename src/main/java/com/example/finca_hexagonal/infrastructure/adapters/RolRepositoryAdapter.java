package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.ports.out.RolModelPort;
import com.example.finca_hexagonal.infrastructure.entities.RolEntity;
import com.example.finca_hexagonal.infrastructure.mappers.RolModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaRolRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RolRepositoryAdapter implements RolModelPort {
    private final JpaRolRepository jpaRolRepository;
    private final RolModelMappers rolModelMappers;

    public RolRepositoryAdapter(JpaRolRepository jpaRolRepository, RolModelMappers rolModelMappers) {
        this.jpaRolRepository = jpaRolRepository;
        this.rolModelMappers = rolModelMappers;
    }

    @Override
    public Rol save(Rol rol) {
        RolEntity rolEntity = rolModelMappers.fromDomainModel(rol);
        RolEntity newRolEntity = jpaRolRepository.save(rolEntity);
        return rolModelMappers.toDomainModel(newRolEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaRolRepository.existsById(id)){
            jpaRolRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Rol> updateById(Long id, Rol rolUpdate) {
        if (jpaRolRepository.existsById(id)){
            RolEntity rolEntity = rolModelMappers.fromDomainModel(rolUpdate);
            rolEntity.setId(id);
            RolEntity updateRolEntity = jpaRolRepository.save(rolEntity);
            return Optional.of(rolModelMappers.toDomainModel(updateRolEntity));
        }
        return Optional.empty();
    }

    @Override
    public List<Rol> findAll() {
        return jpaRolRepository.findAll().stream()
                .map(rolModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return jpaRolRepository.findById(id).map(rolModelMappers::toDomainModel);
    }

}
