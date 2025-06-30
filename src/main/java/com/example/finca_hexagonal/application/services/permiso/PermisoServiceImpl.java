package com.example.finca_hexagonal.application.services.permiso;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.application.mappers.PermisoDTOMapper;
import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.in.permiso.CreatePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.in.permiso.DeletePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.in.permiso.FindPermisoUseCase;
import com.example.finca_hexagonal.domain.ports.in.permiso.UpdatePermisoUseCase;
import com.example.finca_hexagonal.infrastructure.exceptions.OperationFailedException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoServiceImpl implements IPermisoService {

    //Inyectamos los casos de Uso
    private final CreatePermisoUseCase createPermisoUseCase;
    private final DeletePermisoUseCase deletePermisoUseCase;
    private final UpdatePermisoUseCase updatePermisoUseCase;
    private final FindPermisoUseCase findPermisoUseCase;

    //Inyecto el Mapper
    private final PermisoDTOMapper permisoDTOMapper;

    public PermisoServiceImpl(CreatePermisoUseCase createPermisoUseCase,
                              DeletePermisoUseCase deletePermisoUseCase,
                              UpdatePermisoUseCase updatePermisoUseCase,
                              FindPermisoUseCase findPermisoUseCase,
                              PermisoDTOMapper permisoDTOMapper){
        this.createPermisoUseCase=createPermisoUseCase;
        this.deletePermisoUseCase=deletePermisoUseCase;
        this.updatePermisoUseCase=updatePermisoUseCase;
        this.findPermisoUseCase=findPermisoUseCase;
        this.permisoDTOMapper = permisoDTOMapper;
    }


    @Override
    public PermisoResponseDTO create(PermisoRequestDTO permisoRequestDTO) {
        Permiso Permiso = permisoDTOMapper.toModel(permisoRequestDTO);
        Permiso newPermiso = createPermisoUseCase.createPermiso(Permiso);
        return permisoDTOMapper.toDTO(newPermiso) ;
    }

    @Override
    public PermisoResponseDTO findById(Long id) throws  EntityNotFoundException {
        Permiso permiso = findPermisoUseCase.findPermisoById(id);
        return permisoDTOMapper.toDTO(permiso);
    }

    @Override
    public List<PermisoResponseDTO> findAll() {
        return permisoDTOMapper.toListDto(findPermisoUseCase.getAllPermisos());
    }

    @Override
    public PermisoResponseDTO deleteById(Long id) {
        Permiso permiso = findPermisoUseCase.findPermisoById(id);
        Boolean isDeleted = deletePermisoUseCase.deletePermisoById(permiso.getId());
        if(!isDeleted){
            return permisoDTOMapper.toDTO(permiso);
        }
        throw new OperationFailedException("Error al eliminar, la operacion no pudo completarse.");
    }

    @Override
    public PermisoResponseDTO update(Long id, PermisoRequestDTO permisoRequestDTO) {

        Permiso permiso = findPermisoUseCase.findPermisoById(id);
        permiso.setNombre(permisoRequestDTO.nombre());
        Permiso newPermiso = updatePermisoUseCase.updatePermiso(permiso);
        return permisoDTOMapper.toDTO(newPermiso);
    }
}
