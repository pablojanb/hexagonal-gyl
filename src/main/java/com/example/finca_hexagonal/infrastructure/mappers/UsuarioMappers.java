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
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "enabled", target = "enabled"),
            @Mapping(source = "accountNotExpired", target = "accountNotExpired"),
            @Mapping(source = "credentialsNotExpired", target = "credentialsNotExpired"),
            @Mapping(source = "accountNotLocked", target = "accountNotLocked"),
            @Mapping(source = "rolSet", target = "rolEntitySet")
    })
    public abstract UsuarioEntity toEntity(Usuario usuario);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "enabled", target = "enabled"),
            @Mapping(source = "accountNotExpired", target = "accountNotExpired"),
            @Mapping(source = "credentialsNotExpired", target = "credentialsNotExpired"),
            @Mapping(source = "accountNotLocked", target = "accountNotLocked"),
            @Mapping(source = "rolEntitySet", target = "rolSet")
    })
    public abstract Usuario toModel(UsuarioEntity usuarioEntity);

    public abstract List<UsuarioEntity> toListEntity(List<Usuario> usuarioList);

    public abstract List<Usuario> toListModel(List<UsuarioEntity> usuarioEntityList);

}
