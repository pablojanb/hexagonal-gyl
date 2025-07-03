package com.example.finca_hexagonal.application.services.ModoDePago;

import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoRequestDTO;
import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ModoDePagoService {

    ModoDePagoResponseDTO create(ModoDePagoRequestDTO dto);

    List<ModoDePagoResponseDTO> getAll();

    Optional<ModoDePagoResponseDTO> getById(Long id);

    Optional<ModoDePagoResponseDTO> updateById(Long id, ModoDePagoRequestDTO dto);

    boolean delete(Long id);

}
