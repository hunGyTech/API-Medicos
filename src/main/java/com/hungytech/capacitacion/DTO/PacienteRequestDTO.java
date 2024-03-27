package com.hungytech.capacitacion.DTO;
import java.util.Date;
public class PacienteRequestDTO {
    private String nombreApellido;
    private int dni;
    private String grupoSanguineo;
    private String direccion;
    private String genero;
    private String fechaNacimiento;

    public PacienteRequestDTO() {
    }

    public PacienteRequestDTO(String nombreApellido, int dni, String grupoSanguineo, String direccion, String genero, String fechaNacimiento) {
        this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.grupoSanguineo = grupoSanguineo;
        this.direccion = direccion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }
    public int getDni() {
        return dni;
    }
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getGenero() {
        return genero;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
}
