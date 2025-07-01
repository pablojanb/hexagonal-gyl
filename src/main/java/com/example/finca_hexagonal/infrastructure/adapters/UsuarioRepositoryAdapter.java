package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.out.UsuarioModelPort;
import com.example.finca_hexagonal.infrastructure.entities.UsuarioEntity;
import com.example.finca_hexagonal.infrastructure.mappers.UsuarioModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaUsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsuarioRepositoryAdapter implements UsuarioModelPort {
    private final JpaUsuarioRepository jpaUsuarioRepository;
    private final UsuarioModelMappers usuarioModelMappers;

    public UsuarioRepositoryAdapter(JpaUsuarioRepository jpaUsuarioRepository, UsuarioModelMappers usuarioModelMappers) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
        this.usuarioModelMappers = usuarioModelMappers;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioModelMappers.fromDomainModel(usuario);
        UsuarioEntity NewUsuarioEntity = jpaUsuarioRepository.save(usuarioEntity);
        return usuarioModelMappers.toDomainModel(NewUsuarioEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaUsuarioRepository.existsById(id)){
            jpaUsuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Usuario> findAll() {
        return jpaUsuarioRepository.findAll().stream()
                .map(usuarioModelMappers::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return jpaUsuarioRepository.findById(id).map(usuarioModelMappers::toDomainModel);
    }

    @Override
    public Optional<Usuario> updateById(Long id, Usuario usuarioUpdate) {
        if (jpaUsuarioRepository.existsById(id)){
            UsuarioEntity usuarioEntity = usuarioModelMappers.fromDomainModel(usuarioUpdate);
            UsuarioEntity updateUsuarioEntity = jpaUsuarioRepository.save(usuarioEntity);
            return Optional.of(usuarioModelMappers.toDomainModel(updateUsuarioEntity));
        }
        return Optional.empty();
    }
}
