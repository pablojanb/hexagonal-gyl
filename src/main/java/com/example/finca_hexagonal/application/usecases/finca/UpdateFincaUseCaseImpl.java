package com.example.finca_hexagonal.application.usecases.finca;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.ports.in.finca.UpdateFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.FincaRespositoryPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateFincaUseCaseImpl implements UpdateFincaUseCase {
    private final FincaRespositoryPort fincaRespositoryPort;

    public UpdateFincaUseCaseImpl(FincaRespositoryPort fincaRespositoryPort) {
        this.fincaRespositoryPort = fincaRespositoryPort;
    }

    @Override
    public Finca updateFinca(int id, Finca finca) {
        return fincaRespositoryPort.update(id, finca);
    }
}
