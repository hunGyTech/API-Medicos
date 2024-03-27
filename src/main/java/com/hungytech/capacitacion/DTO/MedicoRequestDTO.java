package com.hungytech.capacitacion.DTO;

public class MedicoRequestDTO {
    private int matricula;
    private String nombreApellido;
    public MedicoRequestDTO() {
    }
    public MedicoRequestDTO(int matricula, String nombreApellido) {
        this.matricula = matricula;
        this.nombreApellido = nombreApellido;
    }
    public int getMatricula() {
        return matricula;
    }
    public String getNombreApellido() {
        return nombreApellido;
    }
}
