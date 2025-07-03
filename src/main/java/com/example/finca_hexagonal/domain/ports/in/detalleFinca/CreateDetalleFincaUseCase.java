package com.example.finca_hexagonal.domain.ports.in.detalleFinca;

import com.example.finca_hexagonal.domain.models.DetalleFinca;

public interface CreateDetalleFincaUseCase {
    DetalleFinca create(DetalleFinca detalleFinca);
}
