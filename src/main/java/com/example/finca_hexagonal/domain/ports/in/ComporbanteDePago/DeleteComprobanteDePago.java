package com.example.finca_hexagonal.domain.ports.in.ComporbanteDePago;

import com.example.finca_hexagonal.domain.models.ComprobantePago;

public interface DeleteComprobanteDePago {
    Boolean delete(Long id);
    ComprobantePago logicalDeletion(Long id);
}
