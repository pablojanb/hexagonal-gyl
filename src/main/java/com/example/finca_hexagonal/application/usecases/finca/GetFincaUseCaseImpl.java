package com.example.finca_hexagonal.application.usecases.finca;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.ports.in.finca.GetFincaUseCase;
import com.example.finca_hexagonal.domain.ports.out.FincaModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetFincaUseCaseImpl implements GetFincaUseCase {
    private final FincaModelPort fincaModelPort;

    public GetFincaUseCaseImpl(FincaModelPort fincaModelPort) {
        this.fincaModelPort = fincaModelPort;
    }

    @Override
    public List<Finca> getAllFincas() {
        return fincaModelPort.findAll();
    }

    @Override
    public Optional<Finca> getFincaById(Long id) {
        return fincaModelPort.findById(id);
    }
}
