package com.example.finca_hexagonal.application.mappers;


import com.example.finca_hexagonal.application.dto.direccion.DireccionDTORequest;
import com.example.finca_hexagonal.application.dto.direccion.DireccionDTOResponse;
import com.example.finca_hexagonal.domain.models.Direccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Mapper(componentModel = "spring")
public abstract class DireccionDTOMapper {

    public abstract Direccion toModel(DireccionDTORequest direccionDTORequest);

    public abstract DireccionDTOResponse toDto(Direccion direccion);

    public abstract List<DireccionDTOResponse> toDtoList(List<Direccion> direcciones);






}
