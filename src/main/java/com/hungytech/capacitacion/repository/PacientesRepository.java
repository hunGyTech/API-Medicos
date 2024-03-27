package com.hungytech.capacitacion.repository;

import com.hungytech.capacitacion.models.Paciente;
import org.springframework.data.repository.CrudRepository;
public interface PacientesRepository extends CrudRepository<Paciente, Integer> {
}
