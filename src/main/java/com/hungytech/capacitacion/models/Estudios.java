package com.hungytech.capacitacion.models;

import javax.persistence.*;

@Entity
public class Estudios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private TipoEstudio tipoEstudio;
    private String nombreEstudio;
    private String diagnostico;
    private Float precio;
    @Column(columnDefinition = "TEXT")
    private String imagen64;


    public Estudios() {

    }

    public Estudios(TipoEstudio tipoEstudio, String nombreEstudio, String diagnostico, Float precio, String imagen) {
        this.tipoEstudio = tipoEstudio;
        this.nombreEstudio = nombreEstudio;
        this.diagnostico = diagnostico;
        this.precio = precio;
        this.imagen64 = imagen ;
    }


}