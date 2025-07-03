package com.example.finca_hexagonal.application.usecases.documentacion;

import com.example.finca_hexagonal.domain.ports.in.documentacion.DeleteDocumentacionUseCase;
import com.example.finca_hexagonal.domain.ports.out.DocumentacionModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteDocumentacionUseCasesImpl implements DeleteDocumentacionUseCase {

    private final DocumentacionModelPort documentacionModelPort;

    public DeleteDocumentacionUseCasesImpl(DocumentacionModelPort documentacionModelPort) {
        this.documentacionModelPort = documentacionModelPort;
    }

    @Override
    public boolean deleteDocumentacion(Long id) {
        return documentacionModelPort.deleteById(id);
    }
}
