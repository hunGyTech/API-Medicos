package com.hungytech.capacitacion.API;

import com.hungytech.capacitacion.DTO.MedicoRequestDTO;
import com.hungytech.capacitacion.DTO.PacienteRequestDTO;
import com.hungytech.capacitacion.models.Medico;
import com.hungytech.capacitacion.models.Paciente;
import com.hungytech.capacitacion.models.Persona;
import com.hungytech.capacitacion.services.MedicosServices;
import com.hungytech.capacitacion.services.PacientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ApiRest {

    @Autowired
    MedicosServices medicosServices;

    @Autowired
    PacientesServices pacientesServices;

    @GetMapping(value = "/status")
    @ResponseBody
    public ResponseEntity<Map> status() {
        Map response = new HashMap();
        response.put("status", "OK");
        response.put("code", "200");
        response.put("message", "online");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/addMedico")
    @ResponseBody
    public ResponseEntity<Map<String, String>> addMedico(@RequestBody MedicoRequestDTO medicoRequestDTO) {

        try {

            Medico medico = new Medico(medicoRequestDTO);
            medicosServices.crearMedico(medico);

            Map response = new HashMap();
            response.put("status","OK");
            response.put("code","200");
            response.put("message", "Se agregó el médico correctamente!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (HttpMessageNotReadableException e) {
            return handleBadRequestException(e);
        }
        catch (DataIntegrityViolationException e){
            return handleInternalServerErrorUnique(e, "La matrícula ya se encuentra cargada.");
        }
        catch (Exception e) {
            return handleInternalServerError(e);
        }
    }

    @PostMapping(value = "/addPaciente")
    @ResponseBody
    public ResponseEntity<Map<String, String>> addPaciente(@RequestBody PacienteRequestDTO pacienteRequestDTO) {

        try {

            Paciente paciente = new Paciente(pacienteRequestDTO);
            pacientesServices.crearPaciente(paciente);

            Map response = new HashMap();
            response.put("status","OK");
            response.put("code","200");
            response.put("message", "Se agregó el paciente correctamente!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (HttpMessageNotReadableException e) {
            return handleBadRequestException(e);
        }
        catch (DataIntegrityViolationException e){
            return handleInternalServerErrorUnique(e, "El dni ya se encuentra cargado.");
        }
        catch (Exception e) {
            return handleInternalServerError(e);
        }
    }

    //Excepciones en tiempo de serialización para web services
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleBadRequestException(HttpMessageNotReadableException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "BAD_REQUEST");
        response.put("code", "400");
        response.put("message", "Revise los campos de la solicitud: " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleInternalServerErrorUnique(Exception ex, String message) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "INTERNAL_SERVER_ERROR");
        response.put("code", "500");
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleInternalServerError(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "INTERNAL_SERVER_ERROR");
        response.put("code", "500");
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
