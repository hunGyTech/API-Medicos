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
public class Turnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime fechaYHora;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "matricula")
    private Medico medico;

    private float precio;

    @ManyToOne
    @JoinColumn(name = "id_estudio")
    private Estudios estudio;

}