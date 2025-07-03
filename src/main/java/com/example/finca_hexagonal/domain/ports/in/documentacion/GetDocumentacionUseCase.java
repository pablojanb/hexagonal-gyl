package com.example.finca_hexagonal.domain.ports.in.documentacion;

import com.example.finca_hexagonal.domain.models.Documentacion;

import java.util.List;
import java.util.Optional;

public interface GetDocumentacionUseCase {

    List<Documentacion> getAllDocumentaciones();

    Optional<Documentacion> getDocumentacionById(Long id);
}
