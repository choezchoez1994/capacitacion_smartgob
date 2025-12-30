package com.capacitacion.demo.controllers;

import com.capacitacion.demo.dto.CargaFamiliarDto;
import com.capacitacion.demo.dto.PersonaDto;
import com.capacitacion.demo.services.CargaFamiliarService;
import com.capacitacion.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carga-familia")
public class CargaFamiliaController {

    @Autowired
    private CargaFamiliarService cargaFamiliarService;

    @PostMapping("/save")
    public ResponseEntity<String> guardar(@RequestBody CargaFamiliarDto cargaFamiliarDto) {
        String mensaje = cargaFamiliarService.save(cargaFamiliarDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
    @PostMapping("/update")
    public ResponseEntity<String> editar(@RequestBody CargaFamiliarDto cargaFamiliarDto) {
        String mensaje = cargaFamiliarService.update(cargaFamiliarDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
    @PostMapping("/delete")
    public ResponseEntity<String> eliminar(@RequestBody CargaFamiliarDto cargaFamiliarDto) {
        String mensaje = cargaFamiliarService.delete(cargaFamiliarDto.getIdCarga());
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
}
