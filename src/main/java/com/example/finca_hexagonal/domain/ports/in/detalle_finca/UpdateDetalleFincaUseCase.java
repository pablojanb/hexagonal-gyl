package com.example.finca_hexagonal.domain.ports.in.detalle_finca;

import com.example.finca_hexagonal.domain.models.DetalleFinca;

public interface UpdateDetalleFincaUseCase {
    DetalleFinca update(DetalleFinca detalleFinca);
}
