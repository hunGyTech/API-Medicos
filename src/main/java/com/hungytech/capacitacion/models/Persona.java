package com.hungytech.capacitacion.models;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    protected int dni;
    protected String nombreApellido;
    protected String direccion;
    protected String genero;
    @Temporal(TemporalType.DATE) // Indica que solo se almacena la fecha (sin hora)
    @DateTimeFormat(pattern = "dd-MM-yyyy") // Formato en el que se muestra en las vistas
    protected Date fechaNacimiento;

    public Persona(){}

    public Persona(Integer id, int dni, String nombreApellido, String direccion, String genero, Date fechaNacimiento) {
        this.id = id;
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.direccion = direccion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}



