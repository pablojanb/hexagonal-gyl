package com.example.finca_hexagonal.domain.ports.in.extra_finca;

import com.example.finca_hexagonal.domain.models.ExtraFinca;

public interface CreateExtraFincaUseCase {
    void create(ExtraFinca extraFinca);
}
