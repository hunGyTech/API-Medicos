package com.hungytech.capacitacion.models;
import javax.persistence.Entity;
import java.util.Date;
import java.util.*;

@Entity
public class Paciente extends Persona{
    private HistoriaClinica historiaClinica;
    private String grupoSanguineo;

    public Paciente(int dni, String nombreApellido, Date fechaNacimiento, String direccion, String genero, HistoriaClinica historiaClinica, String grupoSanguineo)
    {
        super(dni, nombreApellido, direccion,genero,fechaNacimiento);
        this.historiaClinica = historiaClinica;
        this.grupoSanguineo = grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    public String getGrupoSanguineo(){
        return grupoSanguineo;
    }

    public List<Estudios> ObtenerHistoriaClinica(dni){

        return 	historiaClinica.getHistoria(dni);
    }


}
