package com.example.finca_hexagonal.application.services.usuario.impl;

import com.example.finca_hexagonal.application.dto.usuario.UsuarioRequestDTO;
import com.example.finca_hexagonal.application.dto.usuario.UsuarioResponseDTO;
import com.example.finca_hexagonal.application.mappers.UsuarioDTOMapper;
import com.example.finca_hexagonal.application.services.rol.impl.RolModelService;
import com.example.finca_hexagonal.application.services.usuario.UsuarioService;
import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import com.example.finca_hexagonal.infrastructure.utils.Password;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioDTOMapper usuarioDTOMapper;
    private final UsuarioModelService usuarioModelService;
    private final RolModelService rolModelService;

    public UsuarioServiceImpl(UsuarioDTOMapper usuarioDTOMapper, UsuarioModelService usuarioModelService, RolModelService rolModelService) {
        this.usuarioDTOMapper = usuarioDTOMapper;
        this.usuarioModelService = usuarioModelService;
        this.rolModelService = rolModelService;
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
        String hashPassword = Password.hashPassword(newData.getPassword());
        usuarioToUpdate.setPassword(hashPassword);
        Usuario usuarioUpdated = usuarioModelService.updateUsuario(id, usuarioToUpdate)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + id));

        return Optional.of(usuarioDTOMapper.toDto(usuarioUpdated));
    }

    @Override
    public Optional<UsuarioResponseDTO> asignarRolAUsuario(Long usuarioId, Long rolId) {
        Rol rol = rolModelService.getRol(rolId)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado: " + rolId));
        Usuario usuario = usuarioModelService.getById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + usuarioId));
        usuario.getRoles().add(rol);
        Usuario usuarioUpdated = usuarioModelService.updateUsuario(usuarioId, usuario)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + usuarioId));
        return Optional.of(usuarioDTOMapper.toDto(usuarioUpdated));
    }

    @Override
    public Optional<UsuarioResponseDTO> deleteRolFromUsuario(Long usuarioId, Long rolId) {
        Rol rol = rolModelService.getRol(rolId)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado: " + rolId));
        Usuario usuario = usuarioModelService.getById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + usuarioId));
        usuario.getRoles().removeIf(rolUser -> rolUser.getId() == rol.getId());
        Usuario usuarioUpdated = usuarioModelService.updateUsuario(usuarioId, usuario)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + usuarioId));
        return Optional.of(usuarioDTOMapper.toDto(usuarioUpdated));
    }
}
