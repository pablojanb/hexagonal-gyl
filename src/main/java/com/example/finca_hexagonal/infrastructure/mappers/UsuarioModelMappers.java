package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.infrastructure.entities.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UsuarioModelMappers {
    public abstract UsuarioEntity fromDomainModel(Usuario usuario);

    public abstract Usuario toDomainModel(UsuarioEntity usuarioEntity);
}
