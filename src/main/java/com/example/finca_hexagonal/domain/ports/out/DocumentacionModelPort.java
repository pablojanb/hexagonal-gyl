package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Documentacion;

import java.util.List;
import java.util.Optional;

public interface DocumentacionModelPort {
    Documentacion save(Documentacion documentacion);

    List<Documentacion> findAll();

    Optional<Documentacion> findById(Long id);

    Optional<Documentacion> updateById(Long id, Documentacion documentacionUpdate);

    boolean deleteById(Long id);
}
