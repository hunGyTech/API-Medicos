package com.hungytech.capacitacion.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity

public class Medico extends Persona {


    @Id
    private int matricula;
    private Especialidades especialidad;

    public Medico() {

    }
    public Medico (int dni, String nombreApellido, String direccion, String genero,
                  Date fechaNacimiento, int matricula, Especialidades especialidad){
        super(dni, nombreApellido, direccion, genero, fechaNacimiento);
        this.matricula = matricula;
        this.especialidad = especialidad;
    }
}
