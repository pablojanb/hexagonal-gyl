package com.example.finca_hexagonal.application.usecases.extra;

import com.example.finca_hexagonal.domain.models.Extra;
import com.example.finca_hexagonal.domain.ports.in.extra.CreateExtraUseCase;
import com.example.finca_hexagonal.domain.ports.out.ExtraModelPort;
import org.springframework.stereotype.Service;

@Service
public class CreateExtraUseCaseImpl implements CreateExtraUseCase {

    private final ExtraModelPort extraModelPort;

    public CreateExtraUseCaseImpl(ExtraModelPort extraModelPort) {
        this.extraModelPort = extraModelPort;
    }

    @Override
    public Extra createExtra(Extra extra) {
        return extraModelPort.save(extra);
    }
}
