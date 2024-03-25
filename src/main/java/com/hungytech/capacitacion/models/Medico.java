package com.hungytech.capacitacion.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;
@Entity
public class Medico extends Persona {

    @Id
    private int matricula;
    @OneToOne
    @JoinColumn(name = "id")
    private Especialidades especialidad;

    public Medico() {

    }

    public Medico(Integer id, int dni, String nombreApellido, String direccion, String genero, Date fechaNacimiento, int matricula, Especialidades especialidad) {
        super(id, dni, nombreApellido, direccion, genero, fechaNacimiento);
        this.matricula = matricula;
        this.especialidad = especialidad;
    }
}
