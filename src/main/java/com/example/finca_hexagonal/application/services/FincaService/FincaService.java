package com.example.finca_hexagonal.application.services.FincaService;

import com.example.finca_hexagonal.application.dto.fincas.FincaRequestDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTO;

import java.util.List;
import java.util.Optional;

public interface FincaService {

    FincaResponseDTO createFinca(FincaRequestDTO fincaDto);

    List<FincaResponseDTO> getAllFincas();

    Optional<FincaResponseDTO> getFincaById(Long id);

    Optional<FincaResponseDTO> updateFinca(Long id, FincaRequestDTO fincaDto);

    boolean deleteFincaById(Long id);

}
