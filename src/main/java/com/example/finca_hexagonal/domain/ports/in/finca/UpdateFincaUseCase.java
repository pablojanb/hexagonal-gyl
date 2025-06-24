package com.example.finca_hexagonal.domain.ports.in.finca;

import com.example.finca_hexagonal.domain.models.Finca;

public interface UpdateFincaUseCase {

    Finca updateFinca(int id, Finca finca);
}
