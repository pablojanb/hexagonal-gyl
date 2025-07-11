package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaReservaRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> findByFincaIdAndFecha(Long fincaId, LocalDate fecha);
}
