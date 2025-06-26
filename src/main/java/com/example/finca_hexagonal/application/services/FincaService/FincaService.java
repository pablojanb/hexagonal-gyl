package com.example.finca_hexagonal.application.services.FincaService;

import com.example.finca_hexagonal.application.dto.fincas.FincaRequestDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTOSimplified;

import java.util.List;
import java.util.Optional;

public interface FincaService {

    FincaResponseDTOSimplified createFinca(FincaRequestDTO fincaDto);

    List<FincaResponseDTOSimplified> getAllFincas();

    Optional<FincaResponseDTOSimplified> getFincaById(Long id);

    Optional<FincaResponseDTOSimplified> updateFinca(Long id, FincaRequestDTO fincaDto);

    boolean deleteFincaById(Long id);

}
