package com.example.finca_hexagonal.domain.ports.in.fecha_Especial;

import com.example.finca_hexagonal.domain.models.Fecha_Especial;

import java.util.List;
import java.util.Optional;

public interface FindFecha_EspecialUseCase {
    List<Fecha_Especial> getAll();
    Optional<Fecha_Especial> getById(Long id_fecha);

}
