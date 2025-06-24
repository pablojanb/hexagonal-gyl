package com.example.finca_hexagonal.application.usecases.finca;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.ports.in.finca.GetFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.FincaRespositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetFincaUseCaseImpl implements GetFincaUseCase {
    private final FincaRespositoryPort fincaRespositoryPort;

    public GetFincaUseCaseImpl(FincaRespositoryPort fincaRespositoryPort) {
        this.fincaRespositoryPort = fincaRespositoryPort;
    }

    @Override
    public List<Finca> getAllFincas() {
        return fincaRespositoryPort.getAll();
    }

    @Override
    public Optional<Finca> getFincaById(int id) {
        return fincaRespositoryPort.getById(id);
    }
}
