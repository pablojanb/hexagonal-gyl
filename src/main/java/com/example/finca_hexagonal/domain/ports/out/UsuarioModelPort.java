package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioModelPort {

    boolean deleteById(Long id);

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Optional<Usuario> updateById(Long id, Usuario usuarioUpdate);
}
