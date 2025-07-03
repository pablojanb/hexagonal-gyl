package com.example.finca_hexagonal.application.services.documentacion;

import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionRequestDTO;
import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionResponseDTO;

import java.util.List;
import java.util.Optional;

public interface DocumentacionService {
    DocumentacionResponseDTO createDocumentacion(DocumentacionRequestDTO documentacion);

    List<DocumentacionResponseDTO> getAllDocumentaciones();

    Optional<DocumentacionResponseDTO> getById(Long id);

    Optional<DocumentacionResponseDTO> updateById(Long id, DocumentacionRequestDTO documentacionUpdate);

    boolean deleteById(Long id);
}
