package com.hungytech.capacitacion.models;
import javax.persistence.*;
import java.util.Date;
import java.util.*;

@Entity
public class Paciente extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    private HistoriaClinica historiaClinica;
    private String grupoSanguineo;

    public Paciente() {

    }

    public Paciente(Integer id, int dni, String nombreApellido, String direccion, String genero, Date fechaNacimiento, Integer id1, HistoriaClinica historiaClinica, String grupoSanguineo) {
        super(id, dni, nombreApellido, direccion, genero, fechaNacimiento);
        this.id = id1;
        this.historiaClinica = historiaClinica;
        this.grupoSanguineo = grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    public String getGrupoSanguineo(){
        return grupoSanguineo;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public List<Estudios> ObtenerHistoriaClinica( int dni){
        return 	null;//historiaClinica.getHistoria(dni);
    }


}
