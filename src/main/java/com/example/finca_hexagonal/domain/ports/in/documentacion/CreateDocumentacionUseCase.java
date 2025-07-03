package com.example.finca_hexagonal.domain.ports.in.documentacion;

import com.example.finca_hexagonal.domain.models.Documentacion;

public interface CreateDocumentacionUseCase {
    Documentacion createDocumentacion(Documentacion documentacion);
}
