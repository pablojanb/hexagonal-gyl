package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaHorarioRepository extends JpaRepository<HorarioEntity, Integer> {
}
