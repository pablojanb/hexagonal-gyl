package com.example.finca_hexagonal.application.usecases.documentacion;

import com.example.finca_hexagonal.domain.models.Documentacion;
import com.example.finca_hexagonal.domain.ports.in.documentacion.GetDocumentacionUseCase;
import com.example.finca_hexagonal.domain.ports.out.DocumentacionModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetDocumentacionUseCasesImpl implements GetDocumentacionUseCase {

    private final DocumentacionModelPort documentacionModelPort;

    public GetDocumentacionUseCasesImpl(DocumentacionModelPort documentacionModelPort) {
        this.documentacionModelPort = documentacionModelPort;
    }

    @Override
    public List<Documentacion> getAllDocumentaciones() {
        return documentacionModelPort.findAll();
    }

    @Override
    public Optional<Documentacion> getDocumentacionById(Long id) {
        return documentacionModelPort.findById(id);
    }
}
