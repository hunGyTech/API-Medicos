package com.hungytech.capacitacion.services;

import com.hungytech.capacitacion.models.Paciente;
import com.hungytech.capacitacion.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacientesServicesImpl implements PacientesServices {
    @Autowired
    PacientesRepository pacientesRepository;

    public void crearPaciente(Paciente paciente) {
        pacientesRepository.save(paciente);
    }
}
