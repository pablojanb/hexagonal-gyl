package com.example.finca_hexagonal.application.usecases.detalleFinca;

import com.example.finca_hexagonal.domain.ports.in.detalleFinca.DeleteDetalleFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.DetalleFincaModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteDetalleFincaUseCaseImpl implements DeleteDetalleFincaUseCase {
    private final DetalleFincaModelPort detalleFincaModelPort;

    public DeleteDetalleFincaUseCaseImpl(DetalleFincaModelPort detalleFincaModelPort){
        this.detalleFincaModelPort = detalleFincaModelPort;
    }

    @Override
    public boolean delete(Long id) {
        return detalleFincaModelPort.delete(id);
    }
}
