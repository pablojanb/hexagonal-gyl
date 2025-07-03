package com.example.finca_hexagonal.application.usecases.extra;

import com.example.finca_hexagonal.domain.models.Extra;
import com.example.finca_hexagonal.domain.ports.in.extra.GetExtraUseCase;
import com.example.finca_hexagonal.domain.ports.out.ExtraModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetCreateUseCaseImpl implements GetExtraUseCase {

    private final ExtraModelPort extraModelPort;

    public GetCreateUseCaseImpl(ExtraModelPort extraModelPort) {
        this.extraModelPort = extraModelPort;
    }

    @Override
    public List<Extra> getAllExtras() {
        return extraModelPort.findAll();
    }

    @Override
    public Optional<Extra> getExtra(Long id) {
        return extraModelPort.findById(id);
    }
}
