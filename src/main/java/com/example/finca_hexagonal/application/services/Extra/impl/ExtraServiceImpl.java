package com.example.finca_hexagonal.application.services.Extra.impl;


import com.example.finca_hexagonal.application.dto.extras.ExtraRequestDTO;
import com.example.finca_hexagonal.application.dto.extras.ExtraResponseDTO;
import com.example.finca_hexagonal.application.mappers.ExtraDTOMapper;
import com.example.finca_hexagonal.application.services.Extra.ExtraService;
import com.example.finca_hexagonal.domain.models.Extra;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExtraServiceImpl implements ExtraService {
    private final ExtraDTOMapper extraDTOMapper;
    private final ExtraModelService extraModelService;

    public ExtraServiceImpl(ExtraDTOMapper extraDTOMapper, ExtraModelService extraModelService) {
        this.extraDTOMapper = extraDTOMapper;
        this.extraModelService = extraModelService;
    }

    @Override
    public ExtraResponseDTO createExtra(ExtraRequestDTO extraDto) {
        Extra extra = extraDTOMapper.toModel(extraDto);
        Extra newExtra = extraModelService.createExtra(extra);
        return extraDTOMapper.toDto(newExtra);
    }

    @Override
    public boolean deleteExtraById(Long id) {
        return extraModelService.deleteExtra(id);
    }

    @Override
    public List<ExtraResponseDTO> getAllExtras() {
        return List.of();
    }

    @Override
    public Optional<ExtraResponseDTO> getExtraById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ExtraResponseDTO> updateExtraById(Long id, ExtraRequestDTO extraUpdateDto) {
        return Optional.empty();
    }
}
