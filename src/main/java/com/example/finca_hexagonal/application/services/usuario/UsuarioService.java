package com.example.finca_hexagonal.application.services.usuario;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequstDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    UsuarioResponseDTO createUsuario(UsuarioRequstDTO usuarioDto);

    boolean deleteUsuarioById(Long id);

    List<UsuarioResponseDTO> getAllUsuarios();

    Optional<UsuarioResponseDTO> getUsuarioById(Long id);

    Optional<UsuarioResponseDTO> updateById(Long id, UsuarioRequstDTO usuarioUpdateDto);
}
