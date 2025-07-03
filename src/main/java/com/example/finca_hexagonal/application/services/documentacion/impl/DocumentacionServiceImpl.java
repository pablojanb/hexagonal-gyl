package com.example.finca_hexagonal.application.services.documentacion.impl;

import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionRequestDTO;
import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionResponseDTO;
import com.example.finca_hexagonal.application.mappers.DocumentacionDTOMapper;
import com.example.finca_hexagonal.application.services.documentacion.DocumentacionService;
import com.example.finca_hexagonal.domain.models.Documentacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentacionServiceImpl implements DocumentacionService {

    private final DocumentacionDTOMapper documentacionDTOMapper;
    private final DocumentacionModelService documentacionModelService;

    public DocumentacionServiceImpl(DocumentacionDTOMapper documentacionDTOMapper, DocumentacionModelService documentacionModelService) {
        this.documentacionDTOMapper = documentacionDTOMapper;
        this.documentacionModelService = documentacionModelService;
    }

    @Override
    public DocumentacionResponseDTO createDocumentacion(DocumentacionRequestDTO documentacionDto) {
        Documentacion documentacion = documentacionDTOMapper.toModel(documentacionDto);
        Documentacion newDocumentacion =  documentacionModelService.createDocumentacion(documentacion);
        return documentacionDTOMapper.toDto(newDocumentacion);
    }

    @Override
    public List<DocumentacionResponseDTO> getAllDocumentaciones() {
        return List.of();
    }

    @Override
    public Optional<DocumentacionResponseDTO> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<DocumentacionResponseDTO> updateById(Long id, DocumentacionRequestDTO documentacionUpdate) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
