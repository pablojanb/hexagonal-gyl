package com.example.finca_hexagonal.application.services.rol;

import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import com.example.finca_hexagonal.domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    RolResponseDTO createRol(RolRequestDTO rol);

    boolean deleteRolById(Long id);

    Optional<RolResponseDTO> updateRolById(Long id, RolRequestDTO rolUpdate);

    List<RolResponseDTO> getRoles();

    Optional<RolResponseDTO> getRolById(Long id);

    Optional<RolResponseDTO> addPermisoARol(Long idRol, Long idPermiso);
}
