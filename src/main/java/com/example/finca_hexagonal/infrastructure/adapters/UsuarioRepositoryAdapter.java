package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.application.mappers.UsuarioDTOMapper;
import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.out.UsuarioModelPort;
import com.example.finca_hexagonal.infrastructure.repositories.JpaUsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryAdapter implements UsuarioModelPort {

    private final UsuarioDTOMapper usuarioDTOMapper;
    private final JpaUsuarioRepository jpaUsuarioRepository;

    public UsuarioRepositoryAdapter(UsuarioDTOMapper usuarioDTOMapper,
                                    JpaUsuarioRepository jpaUsuarioRepository) {
        this.usuarioDTOMapper = usuarioDTOMapper;
        this.jpaUsuarioRepository = jpaUsuarioRepository;
    }


    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return List.of();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> findByName(String nombre_usuario) {
        return Optional.empty();
    }

    @Override
    public Usuario update(Usuario usuario) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public Usuario logicalDeletion(Usuario usuario) {
        return null;
    }
}
