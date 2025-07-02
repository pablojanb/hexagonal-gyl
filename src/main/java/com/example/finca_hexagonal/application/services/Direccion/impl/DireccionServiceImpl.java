package com.example.finca_hexagonal.application.services.Direccion.impl;

import com.example.finca_hexagonal.application.dto.direccion.DireccionDTORequest;
import com.example.finca_hexagonal.application.dto.direccion.DireccionDTOResponse;
import com.example.finca_hexagonal.application.mappers.DireccionDTOMapper;
import com.example.finca_hexagonal.application.services.Direccion.DireccionService;
import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.models.Extra;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionModelService direccionModelService;
    @Autowired
    private DireccionDTOMapper direccionDTOMapper;

    @Override
    public DireccionDTOResponse createDireccion(DireccionDTORequest direccionDto) {
        Direccion direccion = direccionDTOMapper.toModel(direccionDto);
        Direccion newDireccion = direccionModelService.createDireccion(direccion);
        return direccionDTOMapper.toDto(newDireccion);
    }

    @Override
    public boolean deleteById(Long id) {
        return direccionModelService.deleteDireccion(id);
    }

    @Override
    public Optional<DireccionDTOResponse> updateDireccionById(Long id, DireccionDTORequest updateDireccionDto) {
        Direccion direccionToUpdate = direccionModelService.getDireccionById(id)
                .orElseThrow(() -> new EntityNotFoundException("Direccion no encontrada: " + id));
        Direccion newData = direccionDTOMapper.toModel(updateDireccionDto);
        direccionToUpdate.setDireccion(newData.getDireccion());
        direccionToUpdate.setCiudad(newData.getCiudad());
        direccionToUpdate.setProvincia(newData.getProvincia());
        direccionToUpdate.setAclaracion(newData.getAclaracion());
        Direccion direccionUpdated = direccionModelService.updateDireccion(id, direccionToUpdate)
                .orElseThrow(() -> new EntityNotFoundException("Direccion no encontrada: " + id));

        return Optional.of(direccionDTOMapper.toDto(direccionUpdated));
    }

    @Override
    public List<DireccionDTOResponse> getAllDirecciones() {
        List<Direccion> direcciones = direccionModelService.getAllDirecciones();
        return direccionDTOMapper.toDtoList(direcciones);
    }

    @Override
    public Optional<DireccionDTOResponse> getDireccionById(Long id) {
        Direccion direccion = direccionModelService.getDireccionById(id)
                .orElseThrow(() -> new EntityNotFoundException("Direccion no encontrada: " + id));
        return Optional.of(direccionDTOMapper.toDto(direccion));
    }
}
