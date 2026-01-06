package com.capacitacion.demo.controllers.carlos;

import com.capacitacion.demo.dto.carlos.CatalogoContratacionDto;
import com.capacitacion.demo.dto.carlos.TipoProcedimientoDto;
import com.capacitacion.demo.services.carlos.CatalogoContratacionService;
import com.capacitacion.demo.services.carlos.TipoProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras-publicas/TipoProcedimiento")
public class TipoProcedimientoController {

    @Autowired
    private TipoProcedimientoService tipoProcedimientoService;

    @PostMapping("/save")
    public ResponseEntity<String> guardar(@RequestBody TipoProcedimientoDto tipoProcedimientoDto) {
        String mensaje = tipoProcedimientoService.save(tipoProcedimientoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
    @PostMapping("/update")
    public ResponseEntity<String> editar(@RequestBody TipoProcedimientoDto tipoProcedimientoDto) {
        String mensaje = tipoProcedimientoService.update(tipoProcedimientoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(tipoProcedimientoService.procedimientosAll(), HttpStatus.OK);
    }

    @GetMapping("id-tipoProcedimiento/{idtipoProcedimiento}")
    public ResponseEntity<?> listar(@PathVariable Long idtipoProcedimiento) {
        TipoProcedimientoDto tipoProcedimientoDto = tipoProcedimientoService.findTipoProcedimientoById(idtipoProcedimiento);
        if (tipoProcedimientoDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(tipoProcedimientoDto, HttpStatus.OK);
    }
}
