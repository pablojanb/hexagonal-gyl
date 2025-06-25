package com.example.finca_hexagonal.application.usecases.finca;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.ports.in.finca.CreateFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.FincaModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateFincaUseCaseImpl implements CreateFincaUseCase {
    private final FincaModelPort fincaModelPort;

    public CreateFincaUseCaseImpl(FincaModelPort fincaModelPort) {
        this.fincaModelPort = fincaModelPort;
    }

    @Override
    public Finca createFinca(Finca finca) {
        return fincaModelPort.save(finca);
    }
}
