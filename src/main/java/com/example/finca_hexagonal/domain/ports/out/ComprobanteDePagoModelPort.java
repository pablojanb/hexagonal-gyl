package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.ComprobantePago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ComprobanteDePagoModelPort {
    ComprobantePago save(ComprobantePago comprobantePago);

    Page<ComprobantePago> findAll(Pageable pageable);

    Optional<ComprobantePago> findById(Long id);


    Optional<ComprobantePago>  getByModoDePagoId(Long id);

    List<ComprobantePago> getByMonto(BigDecimal monto);

    Boolean delete(Long id);
    ComprobantePago logicalDeletion(Long id);

}
