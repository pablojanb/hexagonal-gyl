package com.example.finca_hexagonal.domain.ports.in.usuario;

import com.example.finca_hexagonal.domain.models.Usuario;

import java.util.Optional;

public interface UpdateUsuarioUseCase {

    Optional<Usuario> updateUsuario(Long id, Usuario usuarioUpdate);
}
