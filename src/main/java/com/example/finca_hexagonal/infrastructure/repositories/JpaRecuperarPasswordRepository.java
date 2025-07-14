package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.RecuperarPasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRecuperarPasswordRepository extends JpaRepository<RecuperarPasswordEntity, Long> {
}
