package com.example.finca_hexagonal.application.services.Extra;

import com.example.finca_hexagonal.application.dto.extras.ExtraRequestDTO;
import com.example.finca_hexagonal.application.dto.extras.ExtraResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ExtraService {
    ExtraResponseDTO createExtra(ExtraRequestDTO extraDto);

    boolean deleteExtraById(Long id);

    List<ExtraResponseDTO> getAllExtras();

    Optional<ExtraResponseDTO> getExtraById(Long id);

    Optional<ExtraResponseDTO> updateExtraById(Long id, ExtraRequestDTO extraUpdateDto);
}
