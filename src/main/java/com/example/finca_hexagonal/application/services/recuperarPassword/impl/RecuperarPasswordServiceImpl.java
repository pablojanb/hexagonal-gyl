package com.example.finca_hexagonal.application.services.recuperarPassword.impl;

import com.example.finca_hexagonal.application.dto.recuperacionPassword.GenerarTokenRequestDTO;
import com.example.finca_hexagonal.application.mappers.RecuperarPasswordDTOMapper;
import com.example.finca_hexagonal.application.services.recuperarPassword.RecuperarPasswordService;
import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecuperarPasswordServiceImpl implements RecuperarPasswordService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private final RecuperarPasswordModelService recuperarPasswordModelService;
    private final RecuperarPasswordDTOMapper recuperarPasswordDTOMapper;

    public RecuperarPasswordServiceImpl(RecuperarPasswordModelService recuperarPasswordModelService, RecuperarPasswordDTOMapper recuperarPasswordDTOMapper) {
        this.recuperarPasswordModelService = recuperarPasswordModelService;
        this.recuperarPasswordDTOMapper = recuperarPasswordDTOMapper;
    }


    @Override
    public RecuperarPassword crearToken(GenerarTokenRequestDTO generarTokenRequestDTO) {
        RecuperarPassword recuperarPassword = recuperarPasswordDTOMapper.toModel(generarTokenRequestDTO);
        recuperarPassword.setToken(UUID.randomUUID().toString());
        RecuperarPassword recuperarPasswordSaved = recuperarPasswordModelService.generarToken(recuperarPassword);
        String token = recuperarPasswordSaved.getToken();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(generarTokenRequestDTO.getEmail());
        message.setFrom(fromEmail);
        message.setSubject("Recuperación de contraseña");
        message.setText("link/" + token);
        mailSender.send(message);
        return recuperarPasswordSaved;
    }

    @Override
    public RecuperarPassword geTokenByEmail(String email) {
        return null;
    }
}
