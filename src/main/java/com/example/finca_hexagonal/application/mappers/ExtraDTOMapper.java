package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.extras.ExtraRequestDTO;
import com.example.finca_hexagonal.application.dto.extras.ExtraResponseDTO;
import com.example.finca_hexagonal.domain.models.Extra;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExtraDTOMapper {

    public abstract Extra toModel(ExtraRequestDTO extraDto);

    public abstract ExtraResponseDTO toDto(Extra extra);

    public abstract List<ExtraResponseDTO> toDtoList(List<Extra> extras);

}
