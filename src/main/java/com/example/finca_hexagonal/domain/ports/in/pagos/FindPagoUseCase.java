package com.example.finca_hexagonal.domain.ports.in.pagos;

import com.example.finca_hexagonal.domain.models.Pago;

import java.awt.print.Pageable;
import org.springframework.data.domain.Page;

public class FindPagoUseCase {

    Page<Pago> getAll(Pageable pageable);
}
