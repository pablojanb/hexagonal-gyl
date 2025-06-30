package com.example.finca_hexagonal.infrastructure.repositories;

import com.example.finca_hexagonal.domain.models.ComprobantePago;
import com.example.finca_hexagonal.infrastructure.entities.ComprobanteDePagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface JpaComprobanteDePagoRepository extends JpaRepository <ComprobanteDePagoEntity, Long>{

    Optional<ComprobantePago> getByModoDePagoId(Long id);

    List<ComprobantePago> getByMonto(BigDecimal monto);
}
