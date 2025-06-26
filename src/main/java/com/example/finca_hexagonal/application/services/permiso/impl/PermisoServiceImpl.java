package com.example.finca_hexagonal.application.services.permiso.impl;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.application.mappers.PermisoDTOMapper;
import com.example.finca_hexagonal.application.mappers.UsuarioDTOMapper;
import com.example.finca_hexagonal.application.services.permiso.IPermisoService;
import com.example.finca_hexagonal.domain.ports.in.usuario.CreateUsuarioUseCase;

import java.util.List;

public class PermisoServiceImpl implements IPermisoService {

    private final PermisoDTOMapper permisoDTOMapper;

    //Inyectamos los casos de Uso
    private final CreateUsuarioUseCase  createUsuarioUseCase;;
    private final UsuarioDTOMapper usuarioDTOMapper;

    public PermisoServiceImpl(PermisoDTOMapper permisoDTOMapper){
        this.permisoDTOMapper = permisoDTOMapper;
    }



    @Override
    public PermisoResponseDTO create(PermisoRequestDTO permisoRequestDTO) {
        return null;
    }

    @Override
    public PermisoResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<PermisoResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public PermisoResponseDTO deleteById(Long id) {
        return null;
    }

    @Override
    public PermisoResponseDTO update(PermisoRequestDTO permisoRequestDTO) {
        return null;
    }
}
