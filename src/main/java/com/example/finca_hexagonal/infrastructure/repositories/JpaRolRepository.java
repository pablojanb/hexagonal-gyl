package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRolRepository extends JpaRepository<RolEntity, Long> {
}
