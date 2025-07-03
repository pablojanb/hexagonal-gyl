package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Documentacion;
import com.example.finca_hexagonal.domain.ports.out.DocumentacionModelPort;
import com.example.finca_hexagonal.infrastructure.entities.DocumentacionEntity;
import com.example.finca_hexagonal.infrastructure.mappers.DocumentacionModelMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaDocumentacionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DocumentacionRepositoryAdapter implements DocumentacionModelPort {

    private final JpaDocumentacionRepository jpaDocumentacionRepository;
    private final DocumentacionModelMappers documentacionModelMappers;

    public DocumentacionRepositoryAdapter(JpaDocumentacionRepository jpaDocumentacionRepository, DocumentacionModelMappers documentacionModelMappers) {
        this.jpaDocumentacionRepository = jpaDocumentacionRepository;
        this.documentacionModelMappers = documentacionModelMappers;
    }

    @Override
    public Documentacion save(Documentacion documentacion) {
        DocumentacionEntity documentacionEntity = documentacionModelMappers.fromDomainModel(documentacion);
        DocumentacionEntity newDocumentacionEntity = jpaDocumentacionRepository.save(documentacionEntity);
        return documentacionModelMappers.toDomainModel(newDocumentacionEntity);
    }

    @Override
    public List<Documentacion> findAll() {
        return List.of();
    }

    @Override
    public Optional<Documentacion> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Documentacion> updateById(Long id, Documentacion documentacionUpdate) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
