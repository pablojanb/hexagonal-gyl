package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import com.example.finca_hexagonal.infrastructure.entities.RecuperarPasswordEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RecuperarPasswordModelMappers {
    public abstract RecuperarPasswordEntity toEntity(RecuperarPassword recuperarPassword);
    public abstract RecuperarPassword toModel(RecuperarPasswordEntity recuperarPassword);
}
