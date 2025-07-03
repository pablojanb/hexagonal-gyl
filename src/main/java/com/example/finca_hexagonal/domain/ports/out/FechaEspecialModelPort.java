package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.models.Horario;

import java.util.List;
import java.util.Optional;

public interface FechaEspecialModelPort {
    FechaEspecial create(FechaEspecial fechaEspecial);

    boolean deleteFechaEspecial(Long id);

    List<FechaEspecial> getAll();

    Optional<FechaEspecial> getById(Long id);

    Optional<FechaEspecial> update(Long id, FechaEspecial fechaEspecial);

    List<FechaEspecial> findAllFechaEspecialByFincaId(Long id);
}
