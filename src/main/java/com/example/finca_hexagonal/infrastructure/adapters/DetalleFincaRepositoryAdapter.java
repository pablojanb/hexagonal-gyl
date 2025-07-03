package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.ports.out.DetalleFincaModelPort;
import com.example.finca_hexagonal.infrastructure.entities.DetalleFincaEntity;
import com.example.finca_hexagonal.infrastructure.mappers.DetalleFincaModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaDetalleFincaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DetalleFincaRepositoryAdapter implements DetalleFincaModelPort {

    private final DetalleFincaModelMappers detalleFincaModelMappers;
    private final JpaDetalleFincaRepository jpaDetalleFincaRepository;

    public DetalleFincaRepositoryAdapter(DetalleFincaModelMappers detalleFincaModelMappers, JpaDetalleFincaRepository jpaDetalleFincaRepository) {
        this.detalleFincaModelMappers = detalleFincaModelMappers;
        this.jpaDetalleFincaRepository = jpaDetalleFincaRepository;
    }


    @Override
    public DetalleFinca save(DetalleFinca detalle) {
        DetalleFincaEntity detalleFincaEntity = detalleFincaModelMappers.fromDomainModel(detalle);
        DetalleFincaEntity newDetalleFincaEntity = jpaDetalleFincaRepository.save(detalleFincaEntity);
        return detalleFincaModelMappers.toDomainModel(newDetalleFincaEntity);
    }

    @Override
    public Optional<DetalleFinca> findById(Long id) {
        return jpaDetalleFincaRepository.findById(id).map(detalleFincaModelMappers::toDomainModel);
    }

    @Override
    public List<DetalleFinca> findAll() {
        return jpaDetalleFincaRepository.findAll().stream()
                .map(detalleFincaModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DetalleFinca> update(Long id, DetalleFinca detalle) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if (jpaDetalleFincaRepository.existsById(id)){
            jpaDetalleFincaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
