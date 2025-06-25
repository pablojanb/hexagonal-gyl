package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.ExtraDetalle;

import java.util.List;
import java.util.Optional;

public interface ExtraDetalleModelPort {
    List<ExtraDetalle> findAll();

    Optional<ExtraDetalle> findById(Long id);

    void save(ExtraDetalle extraDetalle);

    void deleteById(Long id);

    void update(Long id,ExtraDetalle extraDetalle);
}
