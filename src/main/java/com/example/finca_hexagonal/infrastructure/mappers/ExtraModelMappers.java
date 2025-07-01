package com.example.finca_hexagonal.infrastructure.mappers;


import com.example.finca_hexagonal.domain.models.Extra;
import com.example.finca_hexagonal.infrastructure.entities.ExtraEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ExtraModelMappers {
    public abstract ExtraEntity fromDomainModel(Extra extra);

    public abstract Extra toDomainModel(ExtraEntity extraEntity);
}
