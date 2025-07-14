package com.example.finca_hexagonal.application.services.recuperarPassword.impl;

import com.example.finca_hexagonal.application.config.EncriptPassword;
import com.example.finca_hexagonal.application.dto.recuperacionPassword.CambiarPasswordRequestDTO;
import com.example.finca_hexagonal.application.dto.recuperacionPassword.GenerarTokenRequestDTO;
import com.example.finca_hexagonal.application.mappers.RecuperarPasswordDTOMapper;
import com.example.finca_hexagonal.application.services.recuperarPassword.RecuperarPasswordService;
import com.example.finca_hexagonal.application.services.usuario.impl.UsuarioModelService;
import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import com.example.finca_hexagonal.domain.models.Usuario;
import com.example.finca_hexagonal.infrastructure.exceptions.InvalidCredentialsException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecuperarPasswordServiceImpl implements RecuperarPasswordService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EncriptPassword encriptPassword;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private final RecuperarPasswordModelService recuperarPasswordModelService;
    private final UsuarioModelService usuarioModelService;
    private final RecuperarPasswordDTOMapper recuperarPasswordDTOMapper;

    public RecuperarPasswordServiceImpl(RecuperarPasswordModelService recuperarPasswordModelService, UsuarioModelService usuarioModelService, RecuperarPasswordDTOMapper recuperarPasswordDTOMapper) {
        this.recuperarPasswordModelService = recuperarPasswordModelService;
        this.usuarioModelService = usuarioModelService;
        this.recuperarPasswordDTOMapper = recuperarPasswordDTOMapper;
    }


    @Override
    public RecuperarPassword crearToken(GenerarTokenRequestDTO generarTokenRequestDTO) throws MessagingException {

        RecuperarPassword userToken = recuperarPasswordDTOMapper.toModel(generarTokenRequestDTO);
        userToken.setToken(UUID.randomUUID().toString());
        userToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));
        RecuperarPassword userTokenAlreadyExists = recuperarPasswordModelService.obtenerToken(userToken.getEmail());
        if (userTokenAlreadyExists != null) {
            RecuperarPassword userTokenSaved = recuperarPasswordModelService.updateToken(userTokenAlreadyExists.getId(), userToken);
            String token = userTokenSaved.getToken();
            this.enviarMail(token, userToken.getEmail());
            return userTokenSaved;
        }
        RecuperarPassword userTokenSaved = recuperarPasswordModelService.generarToken(userToken);
        String token = userTokenSaved.getToken();
        this.enviarMail(token, userToken.getEmail());
        return userTokenSaved;
    }

    @Override
    public RecuperarPassword cambiarPassword(CambiarPasswordRequestDTO cambiarPasswordRequestDTO) {
        RecuperarPassword recuperarPassword = recuperarPasswordModelService.obtenerToken(cambiarPasswordRequestDTO.getEmail());
        Optional<Usuario> usuarioDB = usuarioModelService.getByEmail(recuperarPassword.getEmail());
        if (recuperarPassword.getExpiresAt().isBefore(LocalDateTime.now()) || usuarioDB.isEmpty()){
            throw new InvalidCredentialsException("El token ha expirado, solicite nuevamente el cambio de contraseña");
        }
        if (recuperarPassword.getToken().equalsIgnoreCase(cambiarPasswordRequestDTO.getToken())) {
            Usuario usuario = usuarioDB.get();
            String passwordNuevo = encriptPassword.encriptPassword(cambiarPasswordRequestDTO.getNuevoPassword());
            usuario.setPassword(passwordNuevo);
            usuarioModelService.updateUsuario(usuario.getId(), usuario);
        } else {
            throw new InvalidCredentialsException("Token inválido");
        }
        return recuperarPassword;
    }

    public void enviarMail(String token, String email) throws MessagingException{
        MimeMessage mensaje = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);
        String linkRecuperacion = "https://reservaya.com/recuperar?token=" + token;
        String html = "<html>" +
                "<body>" +
                "<h2>Recuperación de contraseña</h2>" +
                "<p>Hacé clic en el siguiente enlace para restablecer tu contraseña:</p>" +
                "<p><a href='" + linkRecuperacion + "'>Restablecer contraseña</a></p>" +
                "<p>Si no te redirige automaticamente copia este link: " + linkRecuperacion +
                "<br><p style='color: red;'>No compartas este link con nadie.</p>" +
                "<br><p>Si no solicitaste esto, ignorá este correo.</p>" +
                "</body>" +
                "</html>";
        helper.setTo(email);
        helper.setFrom(fromEmail);
        helper.setSubject("Recuperación de contraseña");
        helper.setText(html, true);
        mailSender.send(mensaje);
    }
}
