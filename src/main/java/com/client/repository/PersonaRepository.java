package com.client.repository;

import com.client.entity.Persona;
import com.client.entity.TipoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByIdAndTipoId(int id, TipoId tipoId);

    List<Persona> findByEdadGreaterThanEqual(int edad);
}
