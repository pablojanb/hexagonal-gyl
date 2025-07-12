package com.example.finca_hexagonal.application.services.Pago;

import com.example.finca_hexagonal.application.dto.pago.PagoRequestDTO;
import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

import java.util.List;
import java.util.Optional;

public interface PagoService {

    PagoResponseDTO save(PagoRequestDTO dto) throws Exception;

    List<PagoResponseDTO> getAllPagos() throws Exception;

    Optional<PagoResponseDTO> getPagoById(Long id) throws Exception;

    Optional<PagoResponseDTO> updatePago(Long id, PagoRequestDTO dto);

    boolean deletePago(Long id);

}
