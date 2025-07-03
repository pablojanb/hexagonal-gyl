package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.ModoDePagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaModoDePagoRepository extends JpaRepository<ModoDePagoEntity, Long> {}