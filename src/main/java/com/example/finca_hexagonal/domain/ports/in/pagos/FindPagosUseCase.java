package com.example.finca_hexagonal.domain.ports.in.pagos;

import com.example.finca_hexagonal.domain.models.Pago;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface FindPagosUseCase {
    Page<Pago> getAll(Pageable pageable);

    Optional<Pago> getById(Integer id);

   Page<Pago> filterPagoByParams(Pageable pageable,
                                 Boolean estado_pago,)
}
