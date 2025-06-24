package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.DetalleFincaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDetalleFincaRepository extends JpaRepository<DetalleFincaEntity, Long> {
}
