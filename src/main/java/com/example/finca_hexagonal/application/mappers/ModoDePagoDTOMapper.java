package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoRequestDTO;
import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoResponseDTO;
import com.example.finca_hexagonal.domain.models.ModoDePago;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModoDePagoDTOMapper {

    ModoDePagoResponseDTO toDto(ModoDePago modoDePago);

    List<ModoDePagoResponseDTO> toDtoList(List<ModoDePago> modoDePagoList);

    ModoDePago toModel(ModoDePagoRequestDTO dto);
}
