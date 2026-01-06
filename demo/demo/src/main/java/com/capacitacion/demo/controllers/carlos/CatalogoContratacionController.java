package com.capacitacion.demo.controllers.carlos;

import com.capacitacion.demo.dto.carlos.CargaFamiliarDto;
import com.capacitacion.demo.dto.carlos.CatalogoContratacionDto;
import com.capacitacion.demo.services.carlos.CargaFamiliarService;
import com.capacitacion.demo.services.carlos.CatalogoContratacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras-publicas/catalogo")
public class CatalogoContratacionController {

    @Autowired
    private CatalogoContratacionService catalogoContratacionService;

    @PostMapping("/save")
    public ResponseEntity<String> guardar(@RequestBody CatalogoContratacionDto catalogoContratacionDto) {
        String mensaje = catalogoContratacionService.save(catalogoContratacionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
    @PostMapping("/update")
    public ResponseEntity<String> editar(@RequestBody CatalogoContratacionDto catalogoContratacionDto) {
        String mensaje = catalogoContratacionService.update(catalogoContratacionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(catalogoContratacionService.cargasAll(), HttpStatus.OK);
    }

    @GetMapping("id-catalogo/{idCatalogo}")
    public ResponseEntity<?> listar(@PathVariable Long idCatalogo) {
        CatalogoContratacionDto catalogoContratacionDto = catalogoContratacionService.findCatalogoContratacionById(idCatalogo);
        if (catalogoContratacionDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(catalogoContratacionDto, HttpStatus.OK);
    }
}
