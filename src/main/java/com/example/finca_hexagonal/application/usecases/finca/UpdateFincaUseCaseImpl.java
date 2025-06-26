package com.example.finca_hexagonal.application.usecases.finca;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.ports.in.finca.UpdateFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.FincaModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateFincaUseCaseImpl implements UpdateFincaUseCase {
    private final FincaModelPort fincaModelPort;

    public UpdateFincaUseCaseImpl(FincaModelPort fincaModelPort) {
        this.fincaModelPort = fincaModelPort;
    }

    @Override
    public Optional<Finca> updateFinca(Long id, Finca finca) {
        return fincaModelPort.update(id, finca);
    }
}
