package com.example.finca_hexagonal.domain.ports.in.extra;

import com.example.finca_hexagonal.domain.models.Extra;

import java.util.List;
import java.util.Optional;

public interface GetExtraUseCase {
    List<Extra> getAllExtras();

    Optional<Extra> getExtra(Long id);
}
