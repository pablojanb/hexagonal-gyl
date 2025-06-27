package com.example.finca_hexagonal.domain.ports.in.ComporbanteDePago;

import com.example.finca_hexagonal.domain.models.ComprobantePago;

public interface CreateComprobanteDePago {
    ComprobantePago create(ComprobantePago comprobantePago);

}
