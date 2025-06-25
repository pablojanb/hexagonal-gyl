package com.example.finca_hexagonal.domain.ports.in.extra_detalle;

import com.example.finca_hexagonal.domain.models.ExtraDetalle;

import java.util.List;

public interface FindeExtraDetalleUseCase {
    ExtraDetalle getById(Long id);
    List<ExtraDetalle> getAll();
}
