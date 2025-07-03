package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.infrastructure.entities.DetalleFincaEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DetalleFincaModelMappers {
    public abstract DetalleFincaEntity fromDomainModel(DetalleFinca detalleFinca);

    public abstract DetalleFinca toDomainModel(DetalleFincaEntity detalleFincaEntity);
}
