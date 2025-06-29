package com.example.finca_hexagonal.application.services.usuario;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;

import java.util.List;

public interface IUsuarioService {

    UsuarioResponseDTO create(UsuarioRequestDTO usuarioRequestDTO);
    UsuarioResponseDTO findById(Long id);
    List<UsuarioResponseDTO> findAll();
    UsuarioResponseDTO deleteById(Long id);
    UsuarioResponseDTO update(Long id, UsuarioRequestDTO usuarioRequestDTO);
    UsuarioResponseDTO findByUsername(String username);
}
