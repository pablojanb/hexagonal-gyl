package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.domain.models.ExtraDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaExtraDetalleRepository extends JpaRepository<ExtraDetalle,Long> {
}
