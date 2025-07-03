package com.example.finca_hexagonal.domain.ports.in.fechaEspecial;

import com.example.finca_hexagonal.domain.models.FechaEspecial;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface GetFechaEspecialUseCase {

    List<FechaEspecial> getAll();

    Optional<FechaEspecial> getById(Long id);
}
