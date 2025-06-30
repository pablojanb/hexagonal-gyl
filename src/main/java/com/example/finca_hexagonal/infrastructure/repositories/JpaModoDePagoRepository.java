package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.infrastructure.entities.ModoDePagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaModoDePagoRepository extends JpaRepository<ModoDePagoEntity, Long> {

    Optional<ModoDePagoEntity> findByTipo(String tipo);

    List<ModoDePagoEntity> findByPago_Id(Long pagoId);
}
