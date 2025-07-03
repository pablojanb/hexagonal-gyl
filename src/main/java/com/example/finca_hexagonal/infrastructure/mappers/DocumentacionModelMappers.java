package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Documentacion;
import com.example.finca_hexagonal.infrastructure.entities.DocumentacionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DocumentacionModelMappers {
    public abstract DocumentacionEntity fromDomainModel(Documentacion documentacion);

    public abstract Documentacion toDomainModel(DocumentacionEntity documentacionEntity);
}
