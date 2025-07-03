package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.ModoDePago;

import java.util.List;
import java.util.Optional;

public interface ModoDePagoModelPort {

    ModoDePago save(ModoDePago modoDePago);

    Optional<ModoDePago> getById(Long id);

    List<ModoDePago> getAll();

    Optional<ModoDePago> updateById(Long id, ModoDePago modoDePago);

    boolean deleteById(Long id);
}
