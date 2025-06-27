package com.example.finca_hexagonal.application.services.rol;

import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import com.example.finca_hexagonal.application.mappers.RolDTOMapper;
import com.example.finca_hexagonal.domain.ports.in.rol.CreateRolUseCase;
import com.example.finca_hexagonal.domain.ports.in.rol.DeleteRolUseCase;
import com.example.finca_hexagonal.domain.ports.in.rol.FindRolUseCase;
import com.example.finca_hexagonal.domain.ports.in.rol.UpdateRolUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService{

    private final CreateRolUseCase createRolUseCase;
    private final UpdateRolUseCase updateRolUseCase;
    private final DeleteRolUseCase deleteRolUseCase;
    private final FindRolUseCase findRolUseCase;

    private final RolDTOMapper rolDTOMapper;

    public RolServiceImpl(CreateRolUseCase createRolUseCase,
                          UpdateRolUseCase updateRolUseCase,
                          DeleteRolUseCase deleteRolUseCase,
                          FindRolUseCase findRolUseCase,
                          RolDTOMapper rolDTOMapper){
        this.createRolUseCase=createRolUseCase;
        this.updateRolUseCase=updateRolUseCase;
        this.deleteRolUseCase=deleteRolUseCase;
        this.findRolUseCase=findRolUseCase;
        this.rolDTOMapper=rolDTOMapper;
    }

    @Override
    public RolResponseDTO create(RolRequestDTO rolRequestDTO) {
        return null;
    }

    @Override
    public RolResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<RolResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public RolResponseDTO deleteById(Long id) {
        return null;
    }

    @Override
    public RolResponseDTO update(Long id, RolRequestDTO rolRequestDTO) {
        return null;
    }
}
