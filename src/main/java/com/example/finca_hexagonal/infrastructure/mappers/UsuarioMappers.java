package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.infrastructure.entities.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = RolMappers.class)
public abstract class UsuarioMappers {

    @Mappings({
            @Mapping(source = "", target = ""),
    })
    public abstract UsuarioEntity toEntity(Usuario usuario);

    public abstract Usuario toDomain(UsuarioEntity usuario);

    public abstract List<UsuarioEntity> toListEntity(List<Usuario> usuarioList);

    public abstract List<Usuario> toListModel(List<UsuarioEntity> usuarioEntityList);

}
