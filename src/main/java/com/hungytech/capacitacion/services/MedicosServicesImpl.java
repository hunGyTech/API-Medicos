package com.hungytech.capacitacion.services;

import com.hungytech.capacitacion.models.Medico;
import com.hungytech.capacitacion.repository.MedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicosServicesImpl implements MedicosServices{

    @Autowired
    MedicosRepository medicosRepository;
    @Override
    public void crearMedico(Medico medico) {
        medicosRepository.save(medico);
    }
}
