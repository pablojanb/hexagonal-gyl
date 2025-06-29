package com.example.finca_hexagonal.application.services.permiso;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import java.util.List;

public interface IPermisoService {
    PermisoResponseDTO create(PermisoRequestDTO permisoRequestDTO);
    PermisoResponseDTO findById(Long id);
    List<PermisoResponseDTO> findAll();
    PermisoResponseDTO deleteById(Long id);
    PermisoResponseDTO update(Long id, PermisoRequestDTO permisoRequestDTO);
}
