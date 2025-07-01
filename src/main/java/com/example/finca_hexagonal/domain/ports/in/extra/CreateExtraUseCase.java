package com.example.finca_hexagonal.domain.ports.in.extra;

import com.example.finca_hexagonal.domain.models.Extra;

public interface CreateExtraUseCase {
    Extra createExtra(Extra extra);
}
