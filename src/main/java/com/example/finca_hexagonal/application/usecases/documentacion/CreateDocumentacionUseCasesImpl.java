package com.example.finca_hexagonal.application.usecases.documentacion;

import com.example.finca_hexagonal.domain.models.Documentacion;
import com.example.finca_hexagonal.domain.ports.in.documentacion.CreateDocumentacionUseCase;
import com.example.finca_hexagonal.domain.ports.out.DocumentacionModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateDocumentacionUseCasesImpl implements CreateDocumentacionUseCase {

    private final DocumentacionModelPort documentacionModelPort;

    public CreateDocumentacionUseCasesImpl(DocumentacionModelPort documentacionModelPort) {
        this.documentacionModelPort = documentacionModelPort;
    }

    @Override
    public Documentacion createDocumentacion(Documentacion documentacion) {
        return documentacionModelPort.save(documentacion);
    }
}
