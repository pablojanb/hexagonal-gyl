package com.example.finca_hexagonal.application.services.permiso.impl;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.application.mappers.PermisoDTOMapper;
import com.example.finca_hexagonal.application.services.permiso.PermisoService;
import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoServiceImpl implements PermisoService {

    private final PermisoModelService permisoModelService;
    private final PermisoDTOMapper permisoDTOMapper;

    public PermisoServiceImpl(PermisoModelService permisoModelService, PermisoDTOMapper permisoDTOMapper) {
        this.permisoModelService = permisoModelService;
        this.permisoDTOMapper = permisoDTOMapper;
    }

    @Override
    public PermisoResponseDTO createPermiso(PermisoRequestDTO permisoDto) {
        Permiso permiso = permisoDTOMapper.toModel(permisoDto);
        Permiso newPermiso = permisoModelService.createPermiso(permiso);
        return permisoDTOMapper.toDto(newPermiso);
    }

    @Override
    public List<PermisoResponseDTO> getPermisos() {
        List<Permiso> permisos = permisoModelService.getAllPermisos();
        return permisoDTOMapper.toDtoList(permisos);
    }

    @Override
    public Optional<PermisoResponseDTO> getPermisoById(Long id) {
        Permiso permiso = permisoModelService.getPermiso(id)
                .orElseThrow(() -> new EntityNotFoundException("Permiso no encontrado con ID: " + id));
        return Optional.of(permisoDTOMapper.toDto(permiso));
    }

    @Override
    public Optional<PermisoResponseDTO> updatePermisoById(Long id, PermisoRequestDTO updatePermiso) {
        Permiso permiso = permisoDTOMapper.toModel(updatePermiso);
        Permiso permisoUpdated = permisoModelService.updatePermiso(id, permiso)
                .orElseThrow(() -> new EntityNotFoundException("Permiso no encontrado con ID: " + id));
        return Optional.of(permisoDTOMapper.toDto(permisoUpdated));
    }

    @Override
    public boolean deletePermisoById(Long id) {
        return permisoModelService.deletePermiso(id);
    }
}
