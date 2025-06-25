package com.example.finca_hexagonal.domain.ports.in.extra_finca;

import com.example.finca_hexagonal.domain.models.ExtraFinca;

import java.util.List;

public interface FindExtraFincaUseCase {
    ExtraFinca getById(Long id);
    List<ExtraFinca> getAll();
}
