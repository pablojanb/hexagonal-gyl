package com.example.finca_hexagonal.application.services.Pago;

import com.example.finca_hexagonal.application.dto.pago.PagoRequestDTO;
import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface PagoService {

    PagoResponseDTO save(PagoRequestDTO dto);

    List<PagoResponseDTO> getAllPagos();

    Optional<PagoResponseDTO> getPagoById(Long id);

    Optional<PagoResponseDTO> updatePago(Long id, PagoRequestDTO dto);

    boolean deletePago(Long id);
}
