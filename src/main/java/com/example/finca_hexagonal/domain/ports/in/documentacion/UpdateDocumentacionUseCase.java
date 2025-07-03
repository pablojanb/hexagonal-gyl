package com.example.finca_hexagonal.domain.ports.in.documentacion;

import com.example.finca_hexagonal.domain.models.Documentacion;

import java.util.Optional;

public interface UpdateDocumentacionUseCase {
    Optional<Documentacion> updateDocumentacion(Long id, Documentacion documentacionUpdate);
}
