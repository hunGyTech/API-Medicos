package com.hungytech.capacitacion.models;
import com.hungytech.capacitacion.DTO.PacienteRequestDTO;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public Paciente(PacienteRequestDTO pacienteRequestDTO) {
        // Validación de la matrícula
        if (pacienteRequestDTO.getDni() == 0) {
            throw new IllegalArgumentException("El dni del paciente no puede ser 0 o estar vacío.");
        }
        if (String.valueOf(pacienteRequestDTO.getDni()).length() != 8) {
            throw new IllegalArgumentException("El dni del paciente debe ser de 8 dígitos para Argentina.");
        }

        try {
            this.dni = Integer.parseInt(String.valueOf(pacienteRequestDTO.getDni()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El dni del paciente debe ser un número entero válido.");
        }

        // Validación del nombre y apellido
        if (pacienteRequestDTO.getNombreApellido() == null || pacienteRequestDTO.getNombreApellido() == "") {
            throw new IllegalArgumentException("El nombre y apellido del paciente no puede ser nulo o estar vacío.");
        }

        // Expresión regular para validar que el nombre no contenga caracteres especiales
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pacienteRequestDTO.getNombreApellido());

        if (!matcher.matches()) {
            throw new IllegalArgumentException("El nombre y apellido del paciente no puede contener caracteres especiales");
        }

        this.nombreApellido = pacienteRequestDTO.getNombreApellido();

        // Validación del formato de fecha de nacimiento
        if(pacienteRequestDTO.getFechaNacimiento()!=null&&!pacienteRequestDTO.getFechaNacimiento().equals("")) {
            String fechaNacimientoString = pacienteRequestDTO.getFechaNacimiento();
            String fechaRegex = "^(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-(19|20)\\d{2}$";

            if (!Pattern.matches(fechaRegex, fechaNacimientoString)) {
                throw new IllegalArgumentException("El formato de la fecha de nacimiento debe ser dd-MM-yyyy.");
            }

            // Parsear la fecha de nacimiento
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false); // No permitir fechas inválidas

            try {
                this.fechaNacimiento = dateFormat.parse(fechaNacimientoString);
            } catch (ParseException e) {
                throw new IllegalArgumentException("La fecha de nacimiento no es válida.");
            }
        }
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
