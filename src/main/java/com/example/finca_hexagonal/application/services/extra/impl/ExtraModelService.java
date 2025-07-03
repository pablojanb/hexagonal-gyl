package com.example.finca_hexagonal.application.services.extra.impl;

import com.example.finca_hexagonal.domain.models.Extra;
import com.example.finca_hexagonal.domain.ports.in.extra.CreateExtraUseCase;
import com.example.finca_hexagonal.domain.ports.in.extra.DeleteExtraUseCase;
import com.example.finca_hexagonal.domain.ports.in.extra.GetExtraUseCase;
import com.example.finca_hexagonal.domain.ports.in.extra.UpdateExtraUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraModelService implements CreateExtraUseCase, GetExtraUseCase, DeleteExtraUseCase, UpdateExtraUseCase {

    private final CreateExtraUseCase createExtraUseCase;
    private final GetExtraUseCase getExtraUseCase;
    private final DeleteExtraUseCase deleteExtraUseCase;
    private final UpdateExtraUseCase updateExtraUseCase;

    public ExtraModelService(CreateExtraUseCase createExtraUseCase, GetExtraUseCase getExtraUseCase, DeleteExtraUseCase deleteExtraUseCase, UpdateExtraUseCase updateExtraUseCase) {
        this.createExtraUseCase = createExtraUseCase;
        this.getExtraUseCase = getExtraUseCase;
        this.deleteExtraUseCase = deleteExtraUseCase;
        this.updateExtraUseCase = updateExtraUseCase;
    }


    @Override
    public Extra createExtra(Extra extra) {
        return createExtraUseCase.createExtra(extra);
    }

    @Override
    public boolean deleteExtra(Long id) {
        return deleteExtraUseCase.deleteExtra(id);
    }

    @Override
    public List<Extra> getAllExtras() {
        return getExtraUseCase.getAllExtras();
    }

    @Override
    public Optional<Extra> getExtra(Long id) {
        return getExtraUseCase.getExtra(id);
    }

    @Override
    public Optional<Extra> updateExtra(Long id, Extra extraUpdate) {
        return updateExtraUseCase.updateExtra(id, extraUpdate);
    }
}
