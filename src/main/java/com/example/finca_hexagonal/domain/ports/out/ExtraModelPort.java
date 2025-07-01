package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Extra;

import java.util.List;
import java.util.Optional;

public interface ExtraModelPort {
    Extra save(Extra extra);

    boolean deleteById(Long id);

    List<Extra> findAll();

    Optional<Extra> findById(Long id);

    Optional<Extra> updateById(Long id, Extra extraUpdate);
}
