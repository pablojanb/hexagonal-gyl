package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.DireccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDireccionRepository extends JpaRepository<DireccionEntity, Long> {
}
