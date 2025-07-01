package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRolRepository extends JpaRepository<RolEntity, Long> {

    Optional<RolEntity> findRolEntityByNombre(String nombre);
}