package com.example.finca_hexagonal.application.mappers;


import com.example.finca_hexagonal.application.dto.fecha_especal.Fecha_EspecialDTORequest;
import com.example.finca_hexagonal.application.dto.fecha_especal.Fecha_EspecialDTOResponse;
import com.example.finca_hexagonal.domain.models.Fecha_Especial;
import org.mapstruct.Mapper;

import java.util.List;

//@Mapper(componentModel = "spring")
public abstract class Fecha_EspecialDTOMapper {

    public abstract Fecha_Especial toModel(Fecha_EspecialDTORequest fecha_EspecialDTORequest);

    public abstract Fecha_EspecialDTOResponse toDto(Fecha_Especial fecha_Especial);

    public abstract List<Fecha_EspecialDTOResponse> toDtoList(List<Fecha_Especial> fechas_Especiales);
}
