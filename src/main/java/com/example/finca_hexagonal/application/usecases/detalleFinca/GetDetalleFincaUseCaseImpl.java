package com.example.finca_hexagonal.application.usecases.detalleFinca;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.ports.in.detalleFinca.FindDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.DetalleFincaModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetDetalleFincaUseCaseImpl implements FindDetalleFincaUseCase {

    private final DetalleFincaModelPort detalleFincaModelPort;

    public GetDetalleFincaUseCaseImpl(DetalleFincaModelPort detalleFincaModelPort){
        this.detalleFincaModelPort = detalleFincaModelPort;
    }

    @Override
    public List<DetalleFinca> getAll() {
        return detalleFincaModelPort.findAll();
    }

    @Override
    public Optional<DetalleFinca> getById(Long id) {
        return detalleFincaModelPort.findById(id);
    }
}
