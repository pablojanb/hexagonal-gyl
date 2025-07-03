package com.example.finca_hexagonal.application.services.documentacion.impl;

import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionRequestDTO;
import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionResponseDTO;
import com.example.finca_hexagonal.application.mappers.DocumentacionDTOMapper;
import com.example.finca_hexagonal.application.services.documentacion.DocumentacionService;
import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.models.Documentacion;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
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
        List<Documentacion> documentaciones = documentacionModelService.getAllDocumentaciones();
        return documentacionDTOMapper.toDtoList(documentaciones);
    }

    @Override
    public Optional<DocumentacionResponseDTO> getById(Long id) {
        Documentacion documentacion = documentacionModelService.getDocumentacionById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documentacion no encontrada: " + id));
        return Optional.of(documentacionDTOMapper.toDto(documentacion));
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
