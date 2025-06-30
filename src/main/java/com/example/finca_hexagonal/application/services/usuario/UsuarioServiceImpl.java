package com.example.finca_hexagonal.application.services.usuario;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.application.mappers.UsuarioDTOMapper;
import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.domain.ports.in.rol.DeleteRolUseCase;
import com.example.finca_hexagonal.domain.ports.in.rol.FindRolUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.CreateUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.DeleteUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.FindUsuarioUseCase;
import com.example.finca_hexagonal.domain.ports.in.usuario.UpdateUsuarioUseCase;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
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
        Usuario usuario = usuarioDTOMapper.toModel(usuarioRequestDTO);
        Usuario newUsuario = createUsuarioUseCase.create(usuario);

        return usuarioDTOMapper.toDto(newUsuario);
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = findUsuarioUseCase.getById(id);
        return usuarioDTOMapper.toDto(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> findAll() {
        return usuarioDTOMapper.toListDto(findUsuarioUseCase.getAll());
    }

    @Override
    public UsuarioResponseDTO deleteById(Long id) {
        Usuario usuario = findUsuarioUseCase.getById(id);
        deleteUsuarioUseCase.deleteById(id);
        return usuarioDTOMapper.toDto(usuario);
    }

    @Override
    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = findUsuarioUseCase.getById(id);
        usuario.setUsername(usuarioRequestDTO.username());
        usuario.setEmail(usuarioRequestDTO.email());
        Usuario newUsuario = updateUsuarioUseCase.update(usuario);
        return usuarioDTOMapper.toDto(newUsuario);
    }

    @Override
    public UsuarioResponseDTO findByUsername(String username) {
        Usuario usuario = findUsuarioUseCase.getByName(username);
        return usuarioDTOMapper.toDto(usuario);
    }
}
