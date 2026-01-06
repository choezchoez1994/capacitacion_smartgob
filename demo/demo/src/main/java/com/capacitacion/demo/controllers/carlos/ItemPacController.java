package com.capacitacion.demo.controllers.carlos;

import com.capacitacion.demo.dto.carlos.CatalogoContratacionDto;
import com.capacitacion.demo.dto.carlos.ItemPacDto;
import com.capacitacion.demo.services.carlos.CatalogoContratacionService;
import com.capacitacion.demo.services.carlos.ItemPacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras-publicas/itemPac")
public class ItemPacController {

    @Autowired
    private ItemPacService itemPacService;

    @PostMapping("/save")
    public ResponseEntity<String> guardar(@RequestBody ItemPacDto itemPacDto) {
        String mensaje = itemPacService.save(itemPacDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
    @PostMapping("/update")
    public ResponseEntity<String> editar(@RequestBody ItemPacDto itemPacDto) {
        String mensaje = itemPacService.update(itemPacDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(itemPacService.pacAll(), HttpStatus.OK);
    }

    @GetMapping("id-pac/{idPac}")
    public ResponseEntity<?> listar(@PathVariable Long idPac) {
        ItemPacDto itemPacDto = itemPacService.findItemPacById(idPac);
        if (itemPacDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(itemPacDto, HttpStatus.OK);
    }

    @GetMapping("periodo/{periodo}/estado/{estado}")
    public ResponseEntity<?> listar(@PathVariable int periodo,@PathVariable String estado) {
        List<ItemPacDto> itemPacDto = itemPacService.getPeriodoYEstado(periodo,estado);
        if (itemPacDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(itemPacDto, HttpStatus.OK);
    }

    @GetMapping("/aprobar/{anio}")
    public ResponseEntity<String> aprobarPorAnio(@PathVariable Integer anio) {
        String mensaje = itemPacService.aprobarPorAnio(anio);
        return ResponseEntity.ok(mensaje);
    }
}
