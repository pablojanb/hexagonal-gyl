package com.example.finca_hexagonal.application.services.permiso;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface PermisoService {
    PermisoResponseDTO createPermiso(PermisoRequestDTO permiso);

    List<PermisoResponseDTO> getPermisos();

    Optional<PermisoResponseDTO> getPermisoById(Long id);

    Optional<PermisoResponseDTO> updatePermisoById(Long id, PermisoRequestDTO updatePermiso);

    boolean deletePermisoById(Long id);
}
