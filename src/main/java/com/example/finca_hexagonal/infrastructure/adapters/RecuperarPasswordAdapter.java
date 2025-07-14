package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import com.example.finca_hexagonal.domain.ports.out.RecuperarPasswordModelPort;
import com.example.finca_hexagonal.infrastructure.entities.RecuperarPasswordEntity;
import com.example.finca_hexagonal.infrastructure.mappers.RecuperarPasswordModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaRecuperarPasswordRepository;
import org.springframework.stereotype.Component;

@Component
public class RecuperarPasswordAdapter implements RecuperarPasswordModelPort {

    private final RecuperarPasswordModelMappers recuperarPasswordModelMappers;
    private final JpaRecuperarPasswordRepository jpaRecuperarPasswordRepository;

    public RecuperarPasswordAdapter(RecuperarPasswordModelMappers recuperarPasswordModelMappers, JpaRecuperarPasswordRepository jpaRecuperarPasswordRepository) {
        this.recuperarPasswordModelMappers = recuperarPasswordModelMappers;
        this.jpaRecuperarPasswordRepository = jpaRecuperarPasswordRepository;
    }

    @Override
    public RecuperarPassword save(RecuperarPassword recuperarPassword) {
        RecuperarPasswordEntity recuperarPasswordEntity = recuperarPasswordModelMappers.toEntity(recuperarPassword);
        RecuperarPasswordEntity recuperarPasswordEntitySaved = jpaRecuperarPasswordRepository.save(recuperarPasswordEntity);
        return recuperarPasswordModelMappers.toModel(recuperarPasswordEntitySaved);
    }

    @Override
    public RecuperarPassword findTokenByEmail(String email) {
        RecuperarPasswordEntity recuperarPasswordEntity = jpaRecuperarPasswordRepository.findByEmail(email);
        return recuperarPasswordModelMappers.toModel(recuperarPasswordEntity);
    }
}
