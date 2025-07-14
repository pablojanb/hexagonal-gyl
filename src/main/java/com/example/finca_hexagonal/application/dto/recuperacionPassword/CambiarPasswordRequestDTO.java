package com.example.finca_hexagonal.application.dto.recuperacionPassword;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CambiarPasswordRequestDTO {
    private String email;
    private String nuevoPassword;
    private String token;
}
