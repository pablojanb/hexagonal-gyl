package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.ports.out.HorarioModelPort;
import com.example.finca_hexagonal.infrastructure.entities.HorarioEntity;
import com.example.finca_hexagonal.infrastructure.mappers.HorarioMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaHorarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class HorarioRepositoryAdapter implements HorarioModelPort {
    private final JpaHorarioRepository jpaHorarioRepository;
    private final HorarioMappers horarioMappers;

    public HorarioRepositoryAdapter(JpaHorarioRepository jpaHorarioRepository, HorarioMappers horarioMappers) {
        this.jpaHorarioRepository = jpaHorarioRepository;
        this.horarioMappers = horarioMappers;
    }


    @Override
    public Horario save(Horario horario) {
        HorarioEntity horarioEntity = horarioMappers.fromDomainModel(horario);
        HorarioEntity newHorarioEntity =  jpaHorarioRepository.save(horarioEntity);
        return horarioMappers.toDomainModel(newHorarioEntity);
    }

    @Override
    public boolean deleteById(Long horarioId) {
        if (jpaHorarioRepository.existsById(horarioId)){
            jpaHorarioRepository.deleteById(horarioId);
            return true;
        }
        return false;
    }

    @Override
    public List<Horario> findAll() {
        return jpaHorarioRepository.findAll().stream()
                .map(horarioMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Horario> findById(Long horarioId) {
        return jpaHorarioRepository.findById(horarioId).map(horarioMappers::toDomainModel);
    }

    @Override
    public Optional<Horario> update(Long horarioId, Horario horario) {
        if (jpaHorarioRepository.existsById(horarioId)){
            HorarioEntity horarioEntity = horarioMappers.fromDomainModel(horario);
            HorarioEntity updateHorarioEntity = jpaHorarioRepository.save(horarioEntity);
            return Optional.of(horarioMappers.toDomainModel(updateHorarioEntity));
        }
        return Optional.empty();
    }
}
