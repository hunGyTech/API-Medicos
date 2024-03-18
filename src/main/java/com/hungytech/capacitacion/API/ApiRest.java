package com.hungytech.capacitacion.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping(value = "/api")
public class ApiRest {
    @GetMapping(value = "/status")
    @ResponseBody
    public ResponseEntity<Map> status()  {
        Map response = new HashMap();
        response.put("status","OK");
        response.put("code","200");
        response.put("message","online");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
