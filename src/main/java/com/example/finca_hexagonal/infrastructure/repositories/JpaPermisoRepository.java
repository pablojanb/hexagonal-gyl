package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.PermisoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPermisoRepository extends JpaRepository<PermisoEntity, Long> {
}
