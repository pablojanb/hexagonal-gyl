package com.example.finca_hexagonal.domain.ports.in.extra_detalle;

import com.example.finca_hexagonal.domain.models.ExtraDetalle;

public interface CreateExtraDetalleUseCase {
    void create(ExtraDetalle extraDetalle);
}
