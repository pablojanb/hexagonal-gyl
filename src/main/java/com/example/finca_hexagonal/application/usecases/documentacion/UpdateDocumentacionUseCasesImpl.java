package com.example.finca_hexagonal.application.usecases.documentacion;

import com.example.finca_hexagonal.domain.models.Documentacion;
import com.example.finca_hexagonal.domain.ports.in.documentacion.UpdateDocumentacionUseCase;
import com.example.finca_hexagonal.domain.ports.out.DocumentacionModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateDocumentacionUseCasesImpl implements UpdateDocumentacionUseCase {

    private final DocumentacionModelPort documentacionModelPort;

    public UpdateDocumentacionUseCasesImpl(DocumentacionModelPort documentacionModelPort) {
        this.documentacionModelPort = documentacionModelPort;
    }

    @Override
    public Optional<Documentacion> updateDocumentacion(Long id, Documentacion documentacionUpdate) {
        return documentacionModelPort.updateById(id, documentacionUpdate);
    }
}
