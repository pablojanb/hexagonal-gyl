package com.example.finca_hexagonal.application.services.fechaEspecial;

//Implementa
import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialRequestDTO;

import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialResponseDTO;

import java.util.List;

public interface FechaEspecialService {

    FechaEspecialResponseDTO create(FechaEspecialRequestDTO fechaEspecialRequestDTO);

    List<FechaEspecialResponseDTO> getAll();

    FechaEspecialResponseDTO getById(Long idfecha);

    FechaEspecialResponseDTO update(Long idfecha, FechaEspecialRequestDTO fechaEspeciaRequestlDTO);

    boolean delete(Long idfecha);

    FechaEspecialResponseDTO logicalDelete(Long id_fecha);

}
