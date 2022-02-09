package com.client.controller;

import com.client.entity.Persona;
import com.client.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/personas")
public class PersonaController {
    @Autowired
    private PersonaServiceImpl personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> listaPersonas(){
        List<Persona> personas = personaService.listAllPersona();
        if (personas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personas);
    }
}
