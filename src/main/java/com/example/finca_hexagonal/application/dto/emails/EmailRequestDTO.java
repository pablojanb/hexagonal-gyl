package com.example.finca_hexagonal.application.dto.emails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailRequestDTO {
    private String to;
    private String subject;
    private String body;
}
