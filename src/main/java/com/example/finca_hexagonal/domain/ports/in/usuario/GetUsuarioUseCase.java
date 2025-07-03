package com.example.finca_hexagonal.domain.ports.in.usuario;

import com.example.finca_hexagonal.domain.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface GetUsuarioUseCase {

    List<Usuario> getAllUsuarios();

    Optional<Usuario> getById(Long id);
}
