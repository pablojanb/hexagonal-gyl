package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.domain.models.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UsuarioDTOMapper {

    public abstract Usuario toModel(UsuarioRequestDTO usuarioDto);

    public abstract UsuarioResponseDTO toDto(Usuario usuario);

    public abstract List<UsuarioResponseDTO> toDtoList(List<Usuario> usuarios);

}
