package com.example.finca_hexagonal.application.usecases.finca;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.ports.in.finca.CreateFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.FincaRespositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateFincaUseCaseImpl implements CreateFincaUseCase {
    private final FincaRespositoryPort fincaRespositoryPort;

    public CreateFincaUseCaseImpl(FincaRespositoryPort fincaRespositoryPort) {
        this.fincaRespositoryPort = fincaRespositoryPort;
    }

    @Override
    public Finca createFinca(Finca finca) {
        return fincaRespositoryPort.save(finca);
    }
}
