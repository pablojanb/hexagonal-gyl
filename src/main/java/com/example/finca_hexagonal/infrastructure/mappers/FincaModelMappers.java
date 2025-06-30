package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.infrastructure.entities.FincaEntity;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public abstract class FincaModelMappers {

    public abstract FincaEntity fromDomainModel(Finca finca);

    public abstract Finca toDomainModel(FincaEntity fincaEntity);
}


