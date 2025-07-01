package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioModelPort {
    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Usuario findById(Long id);

    Usuario findByName(String username);

    Usuario update(Usuario usuario);

    Boolean deleteById(Long id);

    Boolean logicalDeletion(Usuario usuario);
}
