package com.example.finca_hexagonal.application.usecases.detalleFinca;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.ports.in.detalleFinca.UpdateDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.DetalleFincaModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateDetalleFincaUseCaseImpl implements UpdateDetalleFincaUseCase {
    private final DetalleFincaModelPort detalleFincaModelPort;

    public UpdateDetalleFincaUseCaseImpl(DetalleFincaModelPort detalleFincaModelPort){
        this.detalleFincaModelPort = detalleFincaModelPort;
    }

    @Override
    public Optional<DetalleFinca> update(Long id, DetalleFinca detalleFinca) {
        return detalleFincaModelPort.update(id, detalleFinca);
    }
}
