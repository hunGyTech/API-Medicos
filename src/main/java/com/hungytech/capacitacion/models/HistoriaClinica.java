package com.hungytech.capacitacion.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class HistoriaClinica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int dniPaciente;
	private Date fechaIngreso, fechaCierre;
	private String antecedentesPaciente, antecedentesFamiliares;
	private String medicacion;
	private String tratamiento;
	private String evolucion;
	private String epicrisis;
	@OneToMany
	@JoinColumn(name = "id")
	private List<Estudios> estudios = new ArrayList<>();
	public HistoriaClinica() {
	}
	public HistoriaClinica(int dniPaciente, Date fechaIngreso) {
		this.dniPaciente = dniPaciente;
		this.fechaIngreso = fechaIngreso;
	}

	public int getDniPaciente() {
		return dniPaciente;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getAntecedentesPaciente() {
		return antecedentesPaciente;
	}

	public void setAntecedentesPaciente(String antecedentesPaciente) {
		this.antecedentesPaciente = antecedentesPaciente;
	}

	public String getAntecedentesFamiliares() {
		return antecedentesFamiliares;
	}

	public void setAntecedentesFamiliares(String antecedentesFamiliares) {
		this.antecedentesFamiliares = antecedentesFamiliares;
	}

	public String getMedicacion() {
		return medicacion;
	}


	public void setMedicacion(String medicacion) {
		this.medicacion = medicacion;
	}


	public String getTratamiento() {
		return tratamiento;
	}


	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}


	public String getEvolucion() {
		return evolucion;
	}


	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}


	public String getEpicrisis() {
		return epicrisis;
	}


	public void setEpicrisis(String epicrisis) {
		this.epicrisis = epicrisis;
	}


	public List<Estudios> getEstudios() {
		return estudios;
	}


	public void agregarEstudios(Estudios nuevoEstudio) {
		estudios.add(nuevoEstudio);
	}
	
	
	
}
