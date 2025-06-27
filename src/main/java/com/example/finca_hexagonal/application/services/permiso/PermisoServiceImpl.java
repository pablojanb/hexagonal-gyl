package com.example.finca_hexagonal.application.services.permiso;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.application.mappers.PermisoDTOMapper;
import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.ports.in.permiso.CreatePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.in.permiso.DeletePermisoUseCase;
import com.example.finca_hexagonal.domain.ports.in.permiso.FindPermisoUseCase;
import com.example.finca_hexagonal.domain.ports.in.permiso.UpdatePermisoUseCase;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

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
    public PermisoResponseDTO findById(Long id) {
        Permiso permiso = findPermisoUseCase.findPermisoById(id)
                .orElseThrow( ()-> new EntityNoFoundException("Permiso con id "+ " no encontrado") );
        return permisoDTOMapper.toDTO(permiso);
    }

    @Override
    public List<PermisoResponseDTO> findAll() {
        return permisoDTOMapper.toListDto(findPermisoUseCase.getAllPermisos());
    }

    @Override
    public PermisoResponseDTO deleteById(Long id) {

        Permiso permiso = findPermisoUseCase.findPermisoById(id)
                .orElseThrow(()-> new EntityNotFoundException("Error al eliminar, Permiso con id "+ " no encontrado.") );

        Boolean isDeleted = deletePermisoUseCase.deletePermisoById(permiso.getId());
        if(!isDeleted){
            return permisoDTOMapper.toDTO(permiso);
        }
        throw new OperationFailedException("Error al eliminar, la operacion no pudo completarse.");
    }

    @Override
    public PermisoResponseDTO update(Long id, PermisoRequestDTO permisoRequestDTO) {

        Permiso permiso = findPermisoUseCase.findPermisoById(id)
                .orElseThrow(()-> new EntityNotFoundException("Error al actualizar, Permiso con id "+ " no encontrado.") );

        permiso.setNombre(permisoRequestDTO.name());
        Permiso newPermiso = updatePermisoUseCase.updatePermiso(permiso);
        return permisoDTOMapper.toDTO(newPermiso);
    }
}
