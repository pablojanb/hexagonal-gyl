package com.example.finca_hexagonal.application.services.usuario.impl;

import com.example.finca_hexagonal.application.config.EncriptPassword;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
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
    private final EncriptPassword encriptPassword;

    public UsuarioServiceImpl(UsuarioDTOMapper usuarioDTOMapper, UsuarioModelService usuarioModelService,
                              EncriptPassword encriptPassword) {
        this.usuarioDTOMapper = usuarioDTOMapper;
        this.usuarioModelService = usuarioModelService;
        this.encriptPassword = encriptPassword;
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
    public Optional<UsuarioResponseDTO> updateById(Long id, UsuarioRequestDTO usuarioUpdateDto) {
        Usuario usuarioToUpdate = usuarioModelService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + id));
        Usuario newData = usuarioDTOMapper.toModel(usuarioUpdateDto);
        usuarioToUpdate.setNombre(newData.getNombre());
        usuarioToUpdate.setApellido(newData.getApellido());
        usuarioToUpdate.setUsername(newData.getUsername());
        usuarioToUpdate.setEmail(newData.getEmail());
        usuarioToUpdate.setTelefono(newData.getTelefono());
        usuarioToUpdate.setEmailAlternativo(newData.getEmailAlternativo());
        usuarioToUpdate.setFechaNac(newData.getFechaNac());
        usuarioToUpdate.setCuentaActiva(newData.isCuentaActiva());
        usuarioToUpdate.setDni(newData.getDni());
        usuarioToUpdate.setRoles(newData.getRoles());

        String password = encriptPassword.encriptPassword(usuarioToUpdate.getPassword());
        usuarioToUpdate.setPassword(password);
        Usuario usuarioUpdated = usuarioModelService.updateUsuario(id, usuarioToUpdate)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + id));

        return Optional.of(usuarioDTOMapper.toDto(usuarioUpdated));
    }

    @Override
    public UsuarioResponseDTO createUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioDTOMapper.toModel(usuarioRequestDTO);
        usuario.setPassword(encriptPassword.encriptPassword(usuario.getPassword()));
        Usuario usuarioCreado = usuarioModelService.createUsuario(usuario);
        return usuarioDTOMapper.toDto(usuarioCreado);
    }
}
