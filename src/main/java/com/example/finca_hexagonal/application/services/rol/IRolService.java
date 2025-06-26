package com.example.finca_hexagonal.application.services.rol;

import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;

import java.util.List;

public interface IRolService {
    RolResponseDTO create(RolRequestDTO rolRequestDTO);
    RolResponseDTO findById(Long id);
    List<RolResponseDTO> findAll();
    RolResponseDTO deleteById(Long id);
    RolResponseDTO update(RolRequestDTO rolRequestDTO);
}
