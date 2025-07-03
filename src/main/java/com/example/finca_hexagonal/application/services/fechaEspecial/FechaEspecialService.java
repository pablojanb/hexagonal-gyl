package com.example.finca_hexagonal.application.services.fechaEspecial;

import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialRequestDTO;

import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialResponseDTO;

import java.util.List;
import java.util.Optional;

public interface FechaEspecialService {

    FechaEspecialResponseDTO create(FechaEspecialRequestDTO fechaEspecialRequestDTO);

    List<FechaEspecialResponseDTO> getAll();

    Optional<FechaEspecialResponseDTO> getById(Long idfecha);

    Optional<FechaEspecialResponseDTO> update(Long idfecha, FechaEspecialRequestDTO fechaEspeciaRequestlDTO);

    boolean delete(Long idfecha);

}
