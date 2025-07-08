package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.out.AuthenticationModelPort;
import com.example.finca_hexagonal.infrastructure.entities.UsuarioEntity;
import com.example.finca_hexagonal.infrastructure.mappers.UsuarioModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaAuthenticationRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationRepositoryAdapter implements AuthenticationModelPort {

    private final JpaAuthenticationRepository jpaAuthenticationRepository;
    private final UsuarioModelMappers usuarioModelMappers;

    public AuthenticationRepositoryAdapter(JpaAuthenticationRepository jpaAuthenticationRepository, UsuarioModelMappers usuarioModelMappers) {
        this.jpaAuthenticationRepository = jpaAuthenticationRepository;
        this.usuarioModelMappers = usuarioModelMappers;
    }

    @Override
    public Usuario findByEmail(String email) {
        UsuarioEntity usuarioEntity = jpaAuthenticationRepository.findByEmail(email);
        return usuarioModelMappers.toDomainModel(usuarioEntity);
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioModelMappers.fromDomainModel(usuario);
        UsuarioEntity NewUsuarioEntity = jpaAuthenticationRepository.save(usuarioEntity);
        return usuarioModelMappers.toDomainModel(NewUsuarioEntity);
    }
}
