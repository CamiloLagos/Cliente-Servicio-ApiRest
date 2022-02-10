package com.persona.repository;

import com.persona.entity.Persona;
import com.persona.entity.TipoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByIdAndTipoId(int id, TipoId tipoId);

    List<Persona> findByEdadGreaterThanEqual(int edad);
}
