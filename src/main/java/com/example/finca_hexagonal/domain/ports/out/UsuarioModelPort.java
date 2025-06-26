package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioModelPort {
    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByName(String nombre_usuario);

    Usuario update(Usuario usuario);

    Boolean deleteById(Long id);

    Usuario logicalDeletion(Usuario usuario);
}
