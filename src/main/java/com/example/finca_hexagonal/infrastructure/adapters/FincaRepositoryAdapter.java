package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.ports.out.FincaModelPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;



@Component
public class FincaRepositoryAdapter implements FincaModelPort {
    @Override
    public Finca save(Finca finca) {
        return null;
    }

    @Override
    public List<Finca> findAll() {
        return List.of();
    }

    @Override
    public Optional<Finca> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Finca> update(Long id, Finca finca) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    //private final JpaFincaRepository jpaFincaRepository;
    //private final FincaModelMappers fincaMappers;



    /*
    public FincaRepositoryAdapter(JpaFincaRepository fincaRepository, FincaModelMappers fincaMappers) {
        this.jpaFincaRepository = fincaRepository;
        this.fincaMappers = fincaMappers;
    }

    @Override
    public Finca save(Finca finca) {
        FincaEntity fincaEntity = fincaMappers.fromDomainModel(finca);
        FincaEntity newFincaEntity =  jpaFincaRepository.save(fincaEntity);
        return fincaMappers.toDomainModel(newFincaEntity);
    }

    @Override
    public List<Finca> findAll() {
        return jpaFincaRepository.findAll().stream()
                .map(fincaMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Finca> findById(Long id) {
        return jpaFincaRepository.findById(id).map(fincaMappers::toDomainModel);
    }

    @Override
    public Optional<Finca> update(Long id, Finca finca) {
        if (jpaFincaRepository.existsById(id)){
            FincaEntity fincaEntity = fincaMappers.fromDomainModel(finca);
            FincaEntity updateFincaEntity = jpaFincaRepository.save(fincaEntity);
            return Optional.of(fincaMappers.toDomainModel(updateFincaEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaFincaRepository.existsById(id)){
            jpaFincaRepository.deleteById(id);
            return true;
        }
        return false;
    }


    */
}
