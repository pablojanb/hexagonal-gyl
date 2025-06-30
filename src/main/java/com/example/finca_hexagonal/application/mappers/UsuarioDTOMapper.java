package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.application.services.usuario.IUsuarioService;
import com.example.finca_hexagonal.domain.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolDTOMapper.class})
public abstract class UsuarioDTOMapper {

    private final IUsuarioService usuarioService;

    public UsuarioDTOMapper(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "rolIdSet", target = "rolSet", qualifiedByName = "mapIdsToRoles"),
            @Mapping(target = "enabled", ignore = true),
            @Mapping(target = "accountNotExpired", ignore = true),
            @Mapping(target = "credentialsNotExpired", ignore = true),
            @Mapping(target = "accountNotLocked", ignore = true),


    })
    public abstract Usuario toModel(UsuarioRequestDTO usuarioRequestDTO);


    @Mappings(value = {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "rolSet", target = "rolResponseDTOSet"),
            @Mapping(source = "enabled", target = "enabled")
    })
    public abstract UsuarioResponseDTO toDto(Usuario usuario);

    public abstract List<UsuarioResponseDTO> toListDto(List<Usuario> usuarios);

}
