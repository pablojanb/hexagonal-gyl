package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.domain.models.Usuario;

import java.util.List;

public abstract class UsuarioDTOMapper {

    public abstract Usuario toModel(UsuarioRequestDTO usuarioRequestDTO);

    public abstract UsuarioResponseDTO toDto(Usuario usuario);

    public abstract List<UsuarioResponseDTO> toListDto(List<Usuario> usuarios);

}
