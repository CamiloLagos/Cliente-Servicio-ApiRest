package com.persona.controller;

import com.persona.entity.Persona;
import com.persona.entity.PersonaResponse;
import com.persona.entity.TipoId;
import com.persona.service.PersonaServiceImpl;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/personas")
public class PersonaController {
    @Autowired
    private PersonaServiceImpl personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> listaPersonas() {
        List<Persona> personas = personaService.listAllPersona();
        if (personas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personas);
    }

    @GetMapping(value = "/{id}-{tipoId}")
    public ResponseEntity<Object> buscarPersona(@PathVariable("id") int id, @PathVariable("tipoId")TipoId tipoId){
        Persona persona = personaService.getPersona(id, tipoId);
        return ResponseEntity.ok(persona);
    }

    @PostMapping
    public String agregarPersonas(@RequestBody Persona persona) {
        log.info("Creando la persona {}", persona);
        //try {
        personaService.crearPersona(persona);

        Gson gson = new Gson();
        return gson.toJson(new PersonaResponse("Correcto", persona)); // done
        //}catch ()
    }

    @PutMapping(value = "/{id}-{tipoId}")
    public ResponseEntity<Object> actualizarPersona(@PathVariable("id") int id, @PathVariable("tipoId")TipoId tipoId, @RequestBody Persona personaDTO){
        log.info("Actualizando la persona con id {}", id);

        personaDTO.setTipoId(tipoId);
        personaDTO.setId(id);
        Persona persona = personaService.updatePersona(personaDTO);

        return ResponseEntity.ok(persona);
    }

//    @DeleteMapping(value = "/{id}-{tipoId}")
//    public ResponseEntity<Object> borrarPersona(@PathVariable("id") int id, @PathVariable("tipoId")TipoId tipoId){
//        log.info("Borrando la persona con id {}", id);
//        Persona persona = personaService.getPersona(id, tipoId);
//        //return personaService.deletePersona(id);
//    }

}
