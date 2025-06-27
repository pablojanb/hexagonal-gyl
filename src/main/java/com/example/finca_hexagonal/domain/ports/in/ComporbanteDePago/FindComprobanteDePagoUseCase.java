package com.example.finca_hexagonal.domain.ports.in.ComporbanteDePago;

import com.example.finca_hexagonal.domain.models.ComprobantePago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FindComprobanteDePagoUseCase {
    Page<ComprobantePago> getAll(Pageable pageable);

    Optional<ComprobantePago> getById(Long id);

    Optional<ComprobantePago>  getByModoDePagoId(Long id);

    List<ComprobantePago> getByMonto(BigDecimal monto);
}
