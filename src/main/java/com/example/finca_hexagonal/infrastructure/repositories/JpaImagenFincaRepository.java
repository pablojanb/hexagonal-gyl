package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.ImagenFincaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaImagenFincaRepository extends JpaRepository<ImagenFincaEntity, Long> {
    List<ImagenFincaEntity> findAllByFincaId(Long fincaId);
}
