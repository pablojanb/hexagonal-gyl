package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.out.UsuarioModelPort;
import com.example.finca_hexagonal.infrastructure.entities.UsuarioEntity;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import com.example.finca_hexagonal.infrastructure.mappers.UsuarioMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioRepositoryAdapter implements UsuarioModelPort {

    private final UsuarioMappers usuarioMappers;
    private final JpaUsuarioRepository jpaUsuarioRepository;

    public UsuarioRepositoryAdapter(UsuarioMappers usuarioMappers,
                                    JpaUsuarioRepository jpaUsuarioRepository) {
        this.usuarioMappers = usuarioMappers;
        this.jpaUsuarioRepository = jpaUsuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = jpaUsuarioRepository.save(usuarioMappers.toEntity(usuario));
        return usuarioMappers.toModel(usuarioEntity);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioMappers.toListModel(jpaUsuarioRepository.findAll());
    }

    @Override
    public Usuario findById(Long id) {
        UsuarioEntity usuarioEntity = jpaUsuarioRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Error, usuario con el id "+" no encontrado"));
        return usuarioMappers.toModel(usuarioEntity);
    }

    @Override
    public Usuario findByName(String username) {
        UsuarioEntity usuarioEntity = jpaUsuarioRepository.findUsuarioEntityByUsername(username)
                .orElseThrow(()->new EntityNotFoundException("Error, usuario con username "+username+" no encontrado"));
        return usuarioMappers.toModel(usuarioEntity);
    }

    @Override
    public Usuario update(Usuario usuario) {
        UsuarioEntity usuarioEntity = jpaUsuarioRepository.save(usuarioMappers.toEntity(usuario));
        return usuarioMappers.toModel(usuarioEntity);
    }

    @Override
    public Boolean deleteById(Long id) {
        Usuario usuario = findById(id);
        jpaUsuarioRepository.delete(usuarioMappers.toEntity(usuario));
        return true;
    }

    @Override
    public Usuario logicalDeletion(Usuario usuario) {
        UsuarioEntity usuarioEntity = jpaUsuarioRepository.save(usuarioMappers.toEntity(usuario));
        return usuarioMappers.toModel(usuarioEntity);
    }
}
