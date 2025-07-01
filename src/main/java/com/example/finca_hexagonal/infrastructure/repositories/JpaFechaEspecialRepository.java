package com.example.finca_hexagonal.infrastructure.repositories;


import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.infrastructure.entities.FechaEspecialEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface JpaFechaEspecialRepository extends JpaRepository<FechaEspecialEntity, Long> {
    List<FechaEspecialEntity> findByFincaId(Long fincaId);

    List<FechaEspecialEntity> findByFincaIdAndDiaSemana(Long fincaId, LocalDateTime diaSemana);

}
