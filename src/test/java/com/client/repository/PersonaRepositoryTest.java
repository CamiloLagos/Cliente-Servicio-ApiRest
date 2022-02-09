package com.client.repository;

import com.client.entity.Persona;
import com.client.entity.TipoId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    public void whenFindByIdAndTipoId_thenResultPersona(){
        Persona persona = Persona.builder()
                .id(12345)
                .apellidos("Lagos")
                .edad(23)
                .tipoId(TipoId.CC)
                .nombres("Camilo")
                .lugarNacimiento("Palmira").build();
        personaRepository.save(persona);

        Persona persona2 = personaRepository.findByIdAndTipoId(12345,TipoId.CC);
        assertEquals(persona2.getNombres(), persona.getNombres());
    }

}