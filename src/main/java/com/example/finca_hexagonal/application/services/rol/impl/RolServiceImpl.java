package com.example.finca_hexagonal.application.services.rol.impl;

import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import com.example.finca_hexagonal.application.mappers.RolDTOMapper;
import com.example.finca_hexagonal.application.services.rol.RolService;
import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    private final RolModelService rolModelService;
    private final RolDTOMapper rolDTOMapper;

    public RolServiceImpl(RolModelService rolModelService, RolDTOMapper rolDTOMapper) {
        this.rolModelService = rolModelService;
        this.rolDTOMapper = rolDTOMapper;
    }

    @Override
    public RolResponseDTO createRol(RolRequestDTO rolDto) {
        Rol rol = rolDTOMapper.toModel(rolDto);
        Rol newRol = rolModelService.createRol(rol);
        return rolDTOMapper.toDto(newRol);
    }

    @Override
    public boolean deleteRolById(Long id) {
        return rolModelService.deleteRol(id);
    }

    @Override
    public Optional<RolResponseDTO> updateRolById(Long id, RolRequestDTO rolUpdate) {
        Rol rol = rolDTOMapper.toModel(rolUpdate);
        Rol rolUpdated = rolModelService.updateRol(id, rol)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado con ID: " + id));
        return Optional.of(rolDTOMapper.toDto(rolUpdated));
    }

    @Override
    public List<RolResponseDTO> getRoles() {
        List<Rol> roles = rolModelService.getRoles();
        return rolDTOMapper.toDtoList(roles);
    }

    @Override
    public Optional<RolResponseDTO> getRolById(Long id) {
        Rol rol = rolModelService.getRol(id)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado con ID: " + id));
        return Optional.of(rolDTOMapper.toDto(rol));
    }
}
