package com.example.finca_hexagonal.domain.ports.in.fecha_Especial;

import com.example.finca_hexagonal.domain.models.Fecha_Especial;

public interface DeleteFecha_EspecialUseCase {
    boolean delete(Long id_fecha);
    Fecha_Especial logicalDelete(Fecha_Especial fecha_Especial);
}
