package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.ports.out.ModoDePagoModelPort;
import com.example.finca_hexagonal.infrastructure.entities.ModoDePagoEntity;
import com.example.finca_hexagonal.infrastructure.mappers.ModoDePagoMapper;
import com.example.finca_hexagonal.infrastructure.repositories.JpaModoDePagoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ModoDePagoAdapter implements ModoDePagoModelPort {

    private final JpaModoDePagoRepository jpaModoDePagoRepository;
    private final ModoDePagoMapper modoDePagoMapper;

    public ModoDePagoAdapter(JpaModoDePagoRepository jpaModoDePagoRepository, ModoDePagoMapper modoDePagoMapper) {
        this.jpaModoDePagoRepository = jpaModoDePagoRepository;
        this.modoDePagoMapper = modoDePagoMapper;
    }

    @Override
    public ModoDePago save(ModoDePago modoDePago) {
        ModoDePagoEntity entity = modoDePagoMapper.toEntity(modoDePago);
        ModoDePagoEntity saved = jpaModoDePagoRepository.save(entity);
        return modoDePagoMapper.toModel(saved);
    }

    @Override
    public Optional<ModoDePago> getById(Long id) {
        return jpaModoDePagoRepository.findById(id)
                .map(modoDePagoMapper::toModel);
    }

    @Override
    public List<ModoDePago> getAll() {
        return jpaModoDePagoRepository.findAll().stream()
                .map(modoDePagoMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ModoDePago> updateById(Long id, ModoDePago modoDePago) {
        return jpaModoDePagoRepository.findById(id)
                .map(entity -> {
                    entity.setNombre(modoDePago.getNombre());
                    ModoDePagoEntity updated = jpaModoDePagoRepository.save(entity);
                    return modoDePagoMapper.toModel(updated);
                });
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaModoDePagoRepository.existsById(id)) {
            jpaModoDePagoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
