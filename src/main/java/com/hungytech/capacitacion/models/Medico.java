package com.hungytech.capacitacion.models;

import com.hungytech.capacitacion.DTO.MedicoRequestDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Medico extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private int matricula;
    @OneToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidades especialidad;

    public Medico() {
    }

    public Medico(Integer id, int dni, String nombreApellido, String direccion, String genero, Date fechaNacimiento, int matricula, Especialidades especialidad) {
        super(id, dni, nombreApellido, direccion, genero, fechaNacimiento);
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    public Medico(MedicoRequestDTO medicoRequestDTO) {
        // Validación de la matrícula
        if (medicoRequestDTO.getMatricula() == 0) {
            throw new IllegalArgumentException("La matrícula del médico no puede ser 0 o estar vacía.");
        }
        if (String.valueOf(medicoRequestDTO.getMatricula()).length() != 4) {
            throw new IllegalArgumentException("La matrícula del médico debe ser de 4 dígitos.");
        }

        try {
            this.matricula = Integer.parseInt(String.valueOf(medicoRequestDTO.getMatricula()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La matrícula del médico debe ser un número entero válido.");
        }

        // Validación del nombre y apellido
        if (medicoRequestDTO.getNombreApellido() == null || medicoRequestDTO.getNombreApellido() == "") {
            throw new IllegalArgumentException("El nombre y apellido del médico no puede ser nulo o estar vacío.");
        }

        // Expresión regular para validar que el nombre no contenga caracteres especiales
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(medicoRequestDTO.getNombreApellido());

        if (!matcher.matches()) {
            throw new IllegalArgumentException("El nombre y apellido del médico no puede contener caracteres especiales");
        }

        this.nombreApellido = medicoRequestDTO.getNombreApellido();
    }


}
