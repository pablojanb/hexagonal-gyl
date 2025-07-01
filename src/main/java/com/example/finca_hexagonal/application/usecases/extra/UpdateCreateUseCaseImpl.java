package com.example.finca_hexagonal.application.usecases.extra;

import com.example.finca_hexagonal.domain.models.Extra;
import com.example.finca_hexagonal.domain.ports.in.extra.UpdateExtraUseCase;
import com.example.finca_hexagonal.domain.ports.out.ExtraModelPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCreateUseCaseImpl implements UpdateExtraUseCase {

    private final ExtraModelPort extraModelPort;

    public UpdateCreateUseCaseImpl(ExtraModelPort extraModelPort) {
        this.extraModelPort = extraModelPort;
    }

    @Override
    public Optional<Extra> updateExtra(Long id, Extra extraUpdate) {
        return extraModelPort.updateById(id, extraUpdate);
    }
}
