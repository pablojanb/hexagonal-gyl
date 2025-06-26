package com.example.finca_hexagonal.application.usecases.finca;

import com.example.finca_hexagonal.domain.ports.in.finca.DeleteFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.FincaModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteFincaUseCaseImpl implements DeleteFincaUseCase {
    private final FincaModelPort fincaModelPort;

    public DeleteFincaUseCaseImpl(FincaModelPort fincaModelPort) {
        this.fincaModelPort = fincaModelPort;
    }

    @Override
    public boolean deleteFincaById(Long id) {
        return fincaModelPort.deleteById(id);
    }
}
