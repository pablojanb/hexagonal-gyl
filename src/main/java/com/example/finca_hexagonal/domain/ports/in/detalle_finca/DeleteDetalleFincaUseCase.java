package com.example.finca_hexagonal.domain.ports.in.detalle_finca;

import com.example.finca_hexagonal.domain.models.DetalleFinca;

public interface DeleteDetalleFincaUseCase {
    DetalleFinca delete(DetalleFinca detalleFinca);
}
