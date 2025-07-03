package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.infrastructure.entities.PagoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract  class PagoModelMappers {
    public abstract PagoEntity toEntity(Pago pago);
    public abstract Pago toModel(PagoEntity pago);
}
