package com.example.finca_hexagonal.infrastructure.mappers;


import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.infrastructure.entities.FechaEspecialEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class FechaEspecialModelMappers {

    public abstract FechaEspecialEntity fromDomainModel(FechaEspecial fechaEspecial);

    public abstract FechaEspecial toDomainModel(FechaEspecialEntity fechaEspecialEntity);

}
