package com.capacitacion.demo.controllers;

import com.capacitacion.demo.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.capacitacion.demo.services.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/Hola")
    public String saludar() {
        return "Hola";
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardar(@RequestBody PersonaDto personaDto) {
        return new ResponseEntity<>(personaService.save(personaDto), HttpStatus.CREATED);
    }
}
