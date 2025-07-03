package com.example.finca_hexagonal.application.services.documentacion.impl;

import com.example.finca_hexagonal.domain.models.Documentacion;
import com.example.finca_hexagonal.domain.ports.in.documentacion.CreateDocumentacionUseCase;
import com.example.finca_hexagonal.domain.ports.in.documentacion.DeleteDocumentacionUseCase;
import com.example.finca_hexagonal.domain.ports.in.documentacion.GetDocumentacionUseCase;
import com.example.finca_hexagonal.domain.ports.in.documentacion.UpdateDocumentacionUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentacionModelService implements CreateDocumentacionUseCase, GetDocumentacionUseCase, UpdateDocumentacionUseCase, DeleteDocumentacionUseCase {

    private final CreateDocumentacionUseCase createDocumentacionUseCase;
    private final GetDocumentacionUseCase getDocumentacionUseCase;
    private final UpdateDocumentacionUseCase updateDocumentacionUseCase;
    private final DeleteDocumentacionUseCase deleteDocumentacionUseCase;

    public DocumentacionModelService(CreateDocumentacionUseCase createDocumentacionUseCase, GetDocumentacionUseCase getDocumentacionUseCase, UpdateDocumentacionUseCase updateDocumentacionUseCase, DeleteDocumentacionUseCase deleteDocumentacionUseCase) {
        this.createDocumentacionUseCase = createDocumentacionUseCase;
        this.getDocumentacionUseCase = getDocumentacionUseCase;
        this.updateDocumentacionUseCase = updateDocumentacionUseCase;
        this.deleteDocumentacionUseCase = deleteDocumentacionUseCase;
    }

    @Override
    public Documentacion createDocumentacion(Documentacion documentacion) {
        return createDocumentacionUseCase.createDocumentacion(documentacion);
    }

    @Override
    public boolean deleteDocumentacion(Long id) {
        return deleteDocumentacionUseCase.deleteDocumentacion(id);
    }

    @Override
    public List<Documentacion> getAllDocumentaciones() {
        return getDocumentacionUseCase.getAllDocumentaciones();
    }

    @Override
    public Optional<Documentacion> getDocumentacionById(Long id) {
        return getDocumentacionUseCase.getDocumentacionById(id);
    }

    @Override
    public Optional<Documentacion> updateDocumentacion(Long id, Documentacion documentacionUpdate) {
        return updateDocumentacionUseCase.updateDocumentacion(id, documentacionUpdate);
    }
}
