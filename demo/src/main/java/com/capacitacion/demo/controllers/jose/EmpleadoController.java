package com.capacitacion.demo.controllers.jose;

import com.capacitacion.demo.dto.jose.EmpleadoDto;
import com.capacitacion.demo.entity.jose.Empleado;
import com.capacitacion.demo.services.jose.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    //Crear empleado
    @PostMapping
    public ResponseEntity<Empleado> crear(@RequestBody EmpleadoDto empleadoDto) {
        Empleado empleado = empleadoService.save(empleadoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    //Editar empleado
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> editar(
            @PathVariable Long id,
            @RequestBody EmpleadoDto empleadoDto) {

        Empleado empleado = empleadoService.update(id, empleadoDto);
        return ResponseEntity.ok(empleado);
    }

    //Eliminar empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
