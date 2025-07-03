package com.example.finca_hexagonal.application.usecases.extra;

import com.example.finca_hexagonal.domain.ports.in.extra.DeleteExtraUseCase;
import com.example.finca_hexagonal.domain.ports.out.ExtraModelPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteCreateUseCaseImpl implements DeleteExtraUseCase {

    private final ExtraModelPort extraModelPort;

    public DeleteCreateUseCaseImpl(ExtraModelPort extraModelPort) {
        this.extraModelPort = extraModelPort;
    }

    @Override
    public boolean deleteExtra(Long id) {
        return extraModelPort.deleteById(id);
    }
}
