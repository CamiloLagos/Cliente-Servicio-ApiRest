package com.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaResponse {
    private String status;
    private Persona persona;
}
