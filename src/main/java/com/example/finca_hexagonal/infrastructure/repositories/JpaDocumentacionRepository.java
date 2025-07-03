package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.DocumentacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDocumentacionRepository extends JpaRepository<DocumentacionEntity, Long> {
}
