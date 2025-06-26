package com.example.finca_hexagonal.domain.ports.in.ModoDePago;

import com.example.finca_hexagonal.domain.models.ModoDePago;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FindModoDePago {
    List<ModoDePago> getAll(Long id);

    Optional<ModoDePago> getById(Long id);

    Optional<ModoDePago> findByTipo(String tipo);

    List<ModoDePago> getByPagoId(Long pago_id);
}