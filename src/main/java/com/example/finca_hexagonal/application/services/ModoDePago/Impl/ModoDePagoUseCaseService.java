//package com.example.finca_hexagonal.application.services.ModoDePago.Impl;
//
//import com.example.finca_hexagonal.domain.models.ModoDePago;
//import com.example.finca_hexagonal.domain.ports.in.modoDePago.CreateModoDepagoUseCase;
//import com.example.finca_hexagonal.domain.ports.in.modoDePago.DeleteModoDePagoUseCase;
//import com.example.finca_hexagonal.domain.ports.in.modoDePago.GetModoDePagoUseCase;
//import com.example.finca_hexagonal.domain.ports.in.modoDePago.UpdateModoDePagoUseCase;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ModoDePagoModelService implements CreateModoDepagoUseCase, GetModoDePagoUseCase, DeleteModoDePagoUseCase, UpdateModoDePagoUseCase {
//
//    private final CreateModoDepagoUseCase createModoDepagoUseCase;
//    private final DeleteModoDePagoUseCase deleteModoDePagoUseCase;
//    private final GetModoDePagoUseCase getModoDePagoUseCase;
//    private final UpdateModoDePagoUseCase updateModoDePagoUseCase;
//
//    public ModoDePagoModelService(CreateModoDepagoUseCase createModoDepagoUseCase, DeleteModoDePagoUseCase deleteModoDePagoUseCase, GetModoDePagoUseCase getModoDePagoUseCase, UpdateModoDePagoUseCase updateModoDePagoUseCase) {
//        this.createModoDepagoUseCase = createModoDepagoUseCase;
//        this.deleteModoDePagoUseCase = deleteModoDePagoUseCase;
//        this.getModoDePagoUseCase = getModoDePagoUseCase;
//        this.updateModoDePagoUseCase = updateModoDePagoUseCase;
//    }
//
//
//    @Override
//    public ModoDePago save(ModoDePago modoDePago) {
//        return createModoDepagoUseCase.save(modoDePago);
//    }
//
//    @Override
//    public boolean deleteById(Long id) {
//        return deleteModoDePagoUseCase.deleteById(id);
//    }
//
//    @Override
//    public Optional<ModoDePago> getById(Long id) {
//        return getModoDePagoUseCase.getById(id);
//    }
//
//    @Override
//    public List<ModoDePago> getAll() {
//        return getModoDePagoUseCase.getAll();
//    }
//
//    @Override
//    public Optional<ModoDePago> updateById(Long id, ModoDePago modoDePago) {
//        return updateModoDePagoUseCase.updateById(id,modoDePago);
//    }
//}

package com.example.finca_hexagonal.application.services.ModoDePago.Impl;

import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.CreateModoDepagoUseCase;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.DeleteModoDePagoUseCase;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.GetModoDePagoUseCase;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.UpdateModoDePagoUseCase;
import com.example.finca_hexagonal.domain.ports.out.ModoDePagoModelPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModoDePagoUseCaseService implements
        CreateModoDepagoUseCase,
        GetModoDePagoUseCase,
        DeleteModoDePagoUseCase,
        UpdateModoDePagoUseCase {

    private final ModoDePagoModelPort modoDePagoModelPort;

    public ModoDePagoUseCaseService(ModoDePagoModelPort modoDePagoModelPort) {
        this.modoDePagoModelPort = modoDePagoModelPort;
    }

    @Override
    public ModoDePago save(ModoDePago modoDePago) {
        return modoDePagoModelPort.save(modoDePago);
    }

    @Override
    public Optional<ModoDePago> getById(Long id) {
        return modoDePagoModelPort.getById(id);
    }

    @Override
    public List<ModoDePago> getAll() {
        return modoDePagoModelPort.getAll();
    }

    @Override
    public Optional<ModoDePago> updateById(Long id, ModoDePago modoDePago) {
        return modoDePagoModelPort.updateById(id, modoDePago);
    }

    @Override
    public boolean deleteById(Long id) {
        return modoDePagoModelPort.deleteById(id);
    }
}
