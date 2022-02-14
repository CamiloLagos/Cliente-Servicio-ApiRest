package com.persona.service;

import com.persona.client.ImagenClient;
import com.persona.entity.Persona;
import com.persona.entity.TipoId;
import com.persona.modelo.Imagen;
import com.persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl {

    @Autowired
    private PersonaRepository personaRepositorio;

    @Autowired
    private ImagenClient imagenClient;


    public List<Persona> listAllPersona() {
        return personaRepositorio.findAll();
    }

    public Persona getPersona(int id, TipoId tipoId) {
        Persona persona = Optional.ofNullable(personaRepositorio.findByIdAndTipoId(id, tipoId)).orElseThrow(()-> new RuntimeException("Persona No Encontrada!"));
        Imagen imagen = imagenClient.buscarImagen(persona.getId()).getBody();
        persona.setImagen(imagen);
        return persona;
    }


    public Persona crearPersona(Persona persona) {
        imagenClient.crearImagen(persona.getImagen());
        return personaRepositorio.save(persona);
    }


    public Persona updatePersona(Persona persona) {
        Persona personaDB = getPersona(persona.getId(), persona.getTipoId());
        if(personaDB == null){
            throw new RuntimeException("No se encontro la persona!");
        }
        return personaRepositorio.save(persona);
    }


    public void deletePersona(int id) {
        personaRepositorio.deleteById(id);
    }


    public List<Persona> findByEdad(int edad) {
        return personaRepositorio.findByEdadGreaterThanEqual(edad);
    }
}
