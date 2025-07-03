package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.infrastructure.entities.ModoDePagoEntity;
import org.mapstruct.Mapper;


    @Mapper(componentModel = "spring")
    public interface ModoDePagoMapper {
        ModoDePago toModel(ModoDePagoEntity entity);
        ModoDePagoEntity toEntity(ModoDePago model);
    }
