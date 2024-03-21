package com.hungytech.capacitacion.API;
import java.util.Date;

public class Persona {
    private int dni;
    private String nombreApellido;
    private String direccion;
    private String genero;
    private Date fechaNacimiento;

    public Persona(int dni, String nombre,String direccion, String genero, Date fechaNacimiento) {
        this.dni = dni;
        this.nombreApellido = nombre;
        this.direccion = direccion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getnombreApellido;() {
        return nombreApellido;;
    }

    public void setnombreApellido;(String nombre) {
        this.nombreApellido; = nombre;
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

    public void setFechaNacimiento(Date fecha){
        this.fechaNacimiento = fecha;
    }



