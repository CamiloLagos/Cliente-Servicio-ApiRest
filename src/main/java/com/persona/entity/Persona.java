package com.persona.entity;

import com.persona.modelo.Imagen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data @Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    private int id;
    @Column(nullable = false)
    private TipoId tipoId;
    private String nombres;
    private String apellidos;
    private int edad;
    @Column(nullable = false)
    private String lugarNacimiento;

    @Transient
    private Imagen imagen;
}
