package com.example.finca_hexagonal.application.usecases.detalleFinca;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.ports.in.detalleFinca.CreateDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.DetalleFincaModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateDetalleFincaUseCaseImpl implements CreateDetalleFincaUseCase {
    private final DetalleFincaModelPort detalleFincaModelPort;

    public CreateDetalleFincaUseCaseImpl(DetalleFincaModelPort detalleFincaModelPort){
        this.detalleFincaModelPort = detalleFincaModelPort;
    }

    @Override
    public DetalleFinca create(DetalleFinca detalleFinca) {
        return detalleFincaModelPort.save(detalleFinca);
    }
}
