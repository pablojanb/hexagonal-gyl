package com.example.finca_hexagonal.application.services.rol;

import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import com.example.finca_hexagonal.application.mappers.RolDTOMapper;
import com.example.finca_hexagonal.domain.models.Rol;
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
        Rol rol = createRolUseCase.create(rolDTOMapper.toModel(rolRequestDTO));
        return rolDTOMapper.toDTO(rol);
    }

    @Override
    public RolResponseDTO findById(Long id) {
        Rol rol = findRolUseCase.getById(id);
        return rolDTOMapper.toDTO(rol);
    }

    @Override
    public List<RolResponseDTO> findAll() {
        return rolDTOMapper.toListDto(findRolUseCase.getAll());
    }

    @Override
    public RolResponseDTO deleteById(Long id) {
        Rol rol = findRolUseCase.getById(id);
        deleteRolUseCase.deleteById(id);
        return rolDTOMapper.toDTO(rol);
    }

    @Override
    public RolResponseDTO update(Long id, RolRequestDTO rolRequestDTO) {
        Rol rol = findRolUseCase.getById(id);
        rol.setNombre(rolRequestDTO.nombre());
        rol = updateRolUseCase.update(rol);
        return rolDTOMapper.toDTO(rol);
    }
}
