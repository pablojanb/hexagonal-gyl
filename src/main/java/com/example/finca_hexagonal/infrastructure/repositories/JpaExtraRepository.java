package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.ExtraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExtraRepository extends JpaRepository<ExtraEntity, Long> {
}