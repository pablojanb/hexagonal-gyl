package com.example.finca_hexagonal.application.services.usuario.impl;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequstDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.application.mappers.UsuarioDTOMapper;
import com.example.finca_hexagonal.application.services.usuario.UsuarioService;
import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioDTOMapper usuarioDTOMapper;
    private final UsuarioModelService usuarioModelService;

    public UsuarioServiceImpl(UsuarioDTOMapper usuarioDTOMapper, UsuarioModelService usuarioModelService) {
        this.usuarioDTOMapper = usuarioDTOMapper;
        this.usuarioModelService = usuarioModelService;
    }

    @Override
    public UsuarioResponseDTO createUsuario(UsuarioRequstDTO usuarioDto) {
        Usuario usuario = usuarioDTOMapper.toModel(usuarioDto);
        Usuario newUsuario = usuarioModelService.createUsuario(usuario);
        return usuarioDTOMapper.toDto(newUsuario);
    }

    @Override
    public boolean deleteUsuarioById(Long id) {
        return usuarioModelService.deleteUsuario(id);
    }

    @Override
    public List<UsuarioResponseDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioModelService.getAllUsuarios();
        return usuarioDTOMapper.toDtoList(usuarios);
    }

    @Override
    public Optional<UsuarioResponseDTO> getUsuarioById(Long id) {
        Usuario usuario = usuarioModelService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + id));
        return Optional.of(usuarioDTOMapper.toDto(usuario));
    }

    @Override
    public Optional<UsuarioResponseDTO> updateById(Long id, UsuarioRequstDTO usuarioUpdateDto) {
        Usuario usuarioToUpdate = usuarioModelService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + id));
        Usuario newData = usuarioDTOMapper.toModel(usuarioUpdateDto);
        usuarioToUpdate.setNombre(newData.getNombre());
        usuarioToUpdate.setApellido(newData.getApellido());
        usuarioToUpdate.setUsername(newData.getUsername());
        usuarioToUpdate.setPassword(newData.getPassword());
        usuarioToUpdate.setEmail(newData.getEmail());
        usuarioToUpdate.setTelefono(newData.getTelefono());
        usuarioToUpdate.setEmailAlternativo(newData.getEmailAlternativo());
        usuarioToUpdate.setFechaNac(newData.getFechaNac());
        usuarioToUpdate.setCuentaActiva(newData.isCuentaActiva());
        usuarioToUpdate.setDni(newData.getDni());
        usuarioToUpdate.setRoles(newData.getRoles());
        Usuario usuarioUpdated = usuarioModelService.updateUsuario(id, usuarioToUpdate)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + id));

        return Optional.of(usuarioDTOMapper.toDto(usuarioUpdated));
    }
}
