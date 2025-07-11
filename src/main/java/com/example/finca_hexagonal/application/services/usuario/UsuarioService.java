package com.example.finca_hexagonal.application.services.usuario;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    boolean deleteUsuarioById(Long id);

    List<UsuarioResponseDTO> getAllUsuarios();

    Optional<UsuarioResponseDTO> getUsuarioById(Long id);

    Optional<UsuarioResponseDTO> updateById(Long id, UsuarioRequestDTO usuarioUpdateDto);

    Optional<UsuarioResponseDTO> asignarRolAUsuario(Long usuarioId, Long rolId);

    Optional<UsuarioResponseDTO> deleteRolFromUsuario(Long usuarioId, Long rolId);
}
