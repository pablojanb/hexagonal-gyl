package com.example.finca_hexagonal.application.usecases.finca;

import com.example.finca_hexagonal.domain.ports.in.finca.DeleteFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.FincaRespositoryPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteFincaUseCaseImpl implements DeleteFincaUseCase {
    private final FincaRespositoryPort fincaRespositoryPort;

    public DeleteFincaUseCaseImpl(FincaRespositoryPort fincaRespositoryPort) {
        this.fincaRespositoryPort = fincaRespositoryPort;
    }

    @Override
    public boolean deleteFincaById(int id) {
        return fincaRespositoryPort.deleteById(id);
    }
}
