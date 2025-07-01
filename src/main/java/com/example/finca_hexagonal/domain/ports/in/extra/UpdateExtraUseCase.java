package com.example.finca_hexagonal.domain.ports.in.extra;

import com.example.finca_hexagonal.domain.models.Extra;

import java.util.Optional;

public interface UpdateExtraUseCase {

    Optional<Extra> updateExtra(Long id, Extra extraUpdate);
}
