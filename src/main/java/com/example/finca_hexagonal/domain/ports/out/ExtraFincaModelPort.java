package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.ExtraFinca;

import java.util.List;
import java.util.Optional;

public interface ExtraFincaModelPort {

    List<ExtraFinca> findAll();

    Optional<ExtraFinca> findById(Long id);

    void save(ExtraFinca extraFinca);

    void deleteById(Long id);

    void update(Long id,ExtraFinca extraFinca);
}
