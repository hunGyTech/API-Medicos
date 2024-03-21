package com.hungytech.capacitacion.models;
import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITYenerationType)
    private int id;

    private LocalDateTime fechaYHora;

    @ManyToOne
    @JoinColumn(name = "paciente_dni")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Medico medico;

    private float precio;

    @ManyToOne
    @JoinColumn(name = "estudio_id")
    private Estudio estudio;

}