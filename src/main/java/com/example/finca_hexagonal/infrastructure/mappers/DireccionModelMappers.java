package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.infrastructure.entities.DireccionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DireccionModelMappers {
    public abstract DireccionEntity fromDomainModel(Direccion direccion);

    public abstract Direccion toDomainModel(DireccionEntity direccionEntity);
}
