package com.example.finca_hexagonal.infrastructure.controllers;

import com.example.finca_hexagonal.application.dto.direccion.DireccionDTORequest;
import com.example.finca_hexagonal.application.dto.direccion.DireccionDTOResponse;
import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionRequestDTO;
import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionResponseDTO;
import com.example.finca_hexagonal.application.services.documentacion.DocumentacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentaciones")
public class DocumentacionController {
    private final DocumentacionService documentacionService;

    public DocumentacionController(DocumentacionService documentacionService) {
        this.documentacionService = documentacionService;
    }

    @PostMapping
    public ResponseEntity<DocumentacionResponseDTO> createDireccion(@RequestBody DocumentacionRequestDTO documentacionDto){
        return new ResponseEntity<>(documentacionService.createDocumentacion(documentacionDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAllDocumentaciones")
    public ResponseEntity<List<DocumentacionResponseDTO>> getAllDocumentaciones(){
        return new ResponseEntity<>(documentacionService.getAllDocumentaciones(), HttpStatus.OK);
    }

    @GetMapping("/getDocumentacionById/{documentacionId}")
    public ResponseEntity<DocumentacionResponseDTO> getDocumentacionById(@PathVariable Long documentacionId){
        return documentacionService.getById(documentacionId)
                .map(documentacion -> new ResponseEntity<>(documentacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateDocumentacion/{documentacionId}")
    public ResponseEntity<DocumentacionResponseDTO> updateDocumentacion(@PathVariable Long documentacionId,
                                                                @RequestBody DocumentacionRequestDTO documentacionUpdate){
        return documentacionService.updateById(documentacionId, documentacionUpdate)
                .map(documentacion -> new ResponseEntity<>(documentacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
