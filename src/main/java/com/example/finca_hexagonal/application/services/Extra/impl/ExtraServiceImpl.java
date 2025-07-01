package com.example.finca_hexagonal.application.services.Extra.impl;


import com.example.finca_hexagonal.application.dto.extras.ExtraRequestDTO;
import com.example.finca_hexagonal.application.dto.extras.ExtraResponseDTO;
import com.example.finca_hexagonal.application.mappers.ExtraDTOMapper;
import com.example.finca_hexagonal.application.services.Extra.ExtraService;
import com.example.finca_hexagonal.domain.models.Extra;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
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
        List<Extra> extras = extraModelService.getAllExtras();
        return extraDTOMapper.toDtoList(extras);
    }

    @Override
    public Optional<ExtraResponseDTO> getExtraById(Long id) {
        Extra extra = extraModelService.getExtra(id)
                .orElseThrow(() -> new EntityNotFoundException("Extra no encontrado: " + id));
        return Optional.of(extraDTOMapper.toDto(extra));
    }

    @Override
    public Optional<ExtraResponseDTO> updateExtraById(Long id, ExtraRequestDTO extraUpdateDto) {
        Extra extraToUpdate = extraModelService.getExtra(id)
                .orElseThrow(() -> new EntityNotFoundException("Extra no encontrado: " + id));
        Extra newData = extraDTOMapper.toModel(extraUpdateDto);
        extraToUpdate.setNombre(newData.getNombre());
        Extra extraUpdated = extraModelService.updateExtra(id, extraToUpdate)
                .orElseThrow(() -> new EntityNotFoundException("Extra no encontrado: " + id));

        return Optional.of(extraDTOMapper.toDto(extraUpdated));
    }
}
