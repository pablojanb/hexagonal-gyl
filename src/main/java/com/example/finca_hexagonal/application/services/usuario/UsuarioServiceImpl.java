package com.example.finca_hexagonal.application.services.usuario;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.application.mappers.UsuarioDTOMapper;
import com.example.finca_hexagonal.domain.ports.in.rol.DeleteRolUseCase;
import com.example.finca_hexagonal.domain.ports.in.rol.FindRolUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.CreateUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.DeleteUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.FindUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.UpdateUsuarioUseCase;


import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService{

    private final CreateUsuarioUseCase createUsuarioUseCase;
    private final FindUsuarioUseCase findUsuarioUseCase;
    private final DeleteUsuarioUseCase deleteUsuarioUseCase;
    private final UpdateUsuarioUseCase updateUsuarioUseCase;

    private final UsuarioDTOMapper usuarioDTOMapper;

    public UsuarioServiceImpl(CreateUsuarioUseCase createUsuarioUseCase,
                              FindUsuarioUseCase findUsuarioUseCase,
                              DeleteUsuarioUseCase deleteUsuarioUseCase,
                              UpdateUsuarioUseCase updateUsuarioUseCase,
                              UsuarioDTOMapper usuarioDTOMapper){
        this.createUsuarioUseCase=createUsuarioUseCase;
        this.findUsuarioUseCase=findUsuarioUseCase;
        this.deleteUsuarioUseCase=deleteUsuarioUseCase;
        this.updateUsuarioUseCase=updateUsuarioUseCase;
        this.usuarioDTOMapper=usuarioDTOMapper;
    }


    @Override
    public UsuarioResponseDTO create(UsuarioRequestDTO usuarioRequestDTO) {
        return null;
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<UsuarioResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public UsuarioResponseDTO deleteById(Long id) {
        return null;
    }

    @Override
    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        return null;
    }

    @Override
    public UsuarioResponseDTO findByUsername(String username) {
        return null;
    }
}
