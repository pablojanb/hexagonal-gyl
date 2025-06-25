package com.example.finca_hexagonal.domain.ports.in.extra_detalle;

import com.example.finca_hexagonal.domain.models.ExtraDetalle;

public interface UpdateExtraDetalleUseCase {
    void update(Long id,ExtraDetalle extraDetalle);
}
