package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaHorarioRepository extends JpaRepository<HorarioEntity, Long> {
    List<HorarioEntity> findByFincaId(Long fincaId);

    List<HorarioEntity> findByFincaIdAndDiaSemana(Long fincaId, String dayOfWeek);
}
