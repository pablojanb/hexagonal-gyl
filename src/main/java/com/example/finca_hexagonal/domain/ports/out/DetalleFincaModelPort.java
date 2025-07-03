package com.example.finca_hexagonal.domain.ports.out;
import com.example.finca_hexagonal.domain.models.DetalleFinca;

import java.util.List;
import java.util.Optional;

public interface DetalleFincaModelPort {

    DetalleFinca save(DetalleFinca detalle);

    Optional<DetalleFinca> findById(Long id);

    List<DetalleFinca> findAll();

    Optional<DetalleFinca> update(Long id, DetalleFinca detalle);

    boolean delete(Long id);
}

