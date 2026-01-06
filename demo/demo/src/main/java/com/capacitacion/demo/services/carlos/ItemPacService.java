package com.capacitacion.demo.services.carlos;

import com.capacitacion.demo.dto.carlos.CargaFamiliarDto;
import com.capacitacion.demo.dto.carlos.ItemPacDto;
import com.capacitacion.demo.dto.carlos.TipoProcedimientoDto;
import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.entity.carlos.CargaFamiliar;
import com.capacitacion.demo.entity.carlos.ItemPac;
import com.capacitacion.demo.entity.carlos.TipoProcedimiento;
import com.capacitacion.demo.mapper.CargaFamiliarMapper;
import com.capacitacion.demo.mapper.ItemPacMapper;
import com.capacitacion.demo.mapper.PersonaMapper;
import com.capacitacion.demo.repository.PersonaRepo;
import com.capacitacion.demo.repository.carlos.CargarFamiliarRepo;
import com.capacitacion.demo.repository.carlos.ItemPacRepo;
import com.capacitacion.demo.repository.carlos.TipoProcedimientoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ItemPacService {


    private  final ItemPacRepo itemPacRepo;
    private  final ItemPacMapper itemPacMapper;
    private  final TipoProcedimientoRepo tipoProcedimientoRepo;


    public String save(ItemPacDto itemPacDto) {
        // Valida que el código no exista
        int anio = java.time.LocalDate.now().getYear();
        if (!itemPacDto.getPeriodo().equals(anio)) {
            return "Error: No se puede ingresar periodos diferentes al actual: " + itemPacDto.getPeriodo();
        }
        if (itemPacDto.getObjetoContratacion() == null || itemPacDto.getObjetoContratacion().isEmpty()) {
            return "Error: Ingrese una descripción(Objeto Contratacion) al PAC.";
        }
        if (itemPacDto.getTipoProcedimientoId() == null) {
            return "Error: Ingrese el tipo de procedimiento.";
        }
        if (itemPacDto.getValorUnitario() == null) {
            return "Error: Ingrese el valor unitario.";
        }
        if (itemPacDto.getCantidad() == null) {
            return "Error: Ingrese la cantidad.";
        }
        if (itemPacDto.getCuatrimestre() == null) {
            return "Error: Ingrese un cuatrimestre.";
        }
        itemPacDto.setEstado("REGISTRADO");
        // Calcular valor total
        itemPacDto.setValorTotal(itemPacDto.getValorUnitario()
                .multiply(BigDecimal.valueOf(itemPacDto.getCantidad())));
        ItemPac itemPac = itemPacMapper.toEntity(itemPacDto);

        // Asignar la relación
        if (itemPacDto.getTipoProcedimientoId() != null) {
            TipoProcedimiento tipoProcedimiento = new TipoProcedimiento();
            tipoProcedimiento.setIdTipoProcedimiento(itemPacDto.getTipoProcedimientoId());
            itemPac.setTipoProcedimiento(tipoProcedimiento);
        }

        // Guardar
        ItemPac itemPacGuardar = itemPacRepo.save(itemPac);
        ItemPacDto dto = itemPacMapper.toDto(itemPacGuardar);

        return "PAC creado exitosamente. ID: " + dto.getIdItemPac() +
                ", Descripción: " + dto.getObjetoContratacion();
    }

    public String update(ItemPacDto itemPacDto) {
        // Valida ID antes de actualizar
        if (itemPacDto.getIdItemPac() == null) {
            return "Error: Se requiere el ID del Item PAC para actualizar";
        }

        ItemPac existeItemPac = itemPacRepo
                .findById(itemPacDto.getIdItemPac())
                .orElse(null);

        if (existeItemPac == null) {
            return "Error: Item PAC no encontrado con ID: " + itemPacDto.getIdItemPac();
        }

        // Validaciones
        if (itemPacDto.getPeriodo() != null && !itemPacDto.getPeriodo().equals(2026)) {
            return "Error: No se puede ingresar periodos diferentes al actual: " + itemPacDto.getPeriodo();
        }

        if (itemPacDto.getObjetoContratacion() != null && itemPacDto.getObjetoContratacion().trim().isEmpty()) {
            return "Error: Ingrese una descripción (Objeto Contratación) al PAC.";
        }

        if (itemPacDto.getTipoProcedimientoId() == null) {
            return "Error: Ingrese el tipo de procedimiento.";
        }

        if (itemPacDto.getValorUnitario() == null) {
            return "Error: Ingrese un valor unitario válido.";
        }

        if (itemPacDto.getCantidad() == null) {
            return "Error: Ingrese una cantidad válida.";
        }

        if (itemPacDto.getCuatrimestre() == null) {
            return "Error: Ingrese un cuatrimestre.";
        }
        // Validar tipo procedimiento solo si viene
        if (itemPacDto.getTipoProcedimientoId() != null) {
            // Opcional: validar que el tipoProcedimiento exista
            boolean tipoProcedimientoExiste = tipoProcedimientoRepo.existsById(itemPacDto.getTipoProcedimientoId());
            if (!tipoProcedimientoExiste) {
                return "Error: El tipo de procedimiento con ID " + itemPacDto.getTipoProcedimientoId() + " no existe";
            }
        }
    //actualizar campos
        if (itemPacDto.getObjetoContratacion() != null || itemPacDto.getObjetoContratacion().isEmpty()) {
            existeItemPac.setObjetoContratacion(itemPacDto.getObjetoContratacion());
        }
        if (itemPacDto.getPeriodo() != null) {
            existeItemPac.setPeriodo(itemPacDto.getPeriodo());
        }

        if (itemPacDto.getCuatrimestre() != null) {
            existeItemPac.setCuatrimestre(itemPacDto.getCuatrimestre());
        }

        // Actualizar valores decimales
        if (itemPacDto.getValorUnitario() != null) {
            existeItemPac.setValorUnitario(itemPacDto.getValorUnitario());
        }

        if (itemPacDto.getCantidad() != null) {
            existeItemPac.setCantidad(itemPacDto.getCantidad());
        }

        existeItemPac.setValorTotal(itemPacDto.getValorUnitario()
                .multiply(BigDecimal.valueOf(itemPacDto.getCantidad())));

        // Actualizar estado
        if (itemPacDto.getEstado() != null) {
            existeItemPac.setEstado(itemPacDto.getEstado());
        }

        // Actualizar relación con tipo de procedimiento
        if (itemPacDto.getTipoProcedimientoId() != null) {
            TipoProcedimiento tipoProcedimiento = new TipoProcedimiento();
            tipoProcedimiento.setIdTipoProcedimiento(itemPacDto.getTipoProcedimientoId());
            existeItemPac.setTipoProcedimiento(tipoProcedimiento);
        }
        ItemPac itemPacGuardar = itemPacRepo.save(existeItemPac);
        ItemPacDto dto = itemPacMapper.toDto(itemPacGuardar);
        return "PAC actualizado exitosamente. ID: " + dto.getIdItemPac() +
                ", Descripción: " + dto.getObjetoContratacion();
    }

    public List<ItemPacDto> pacAll() {
        return itemPacMapper.toDtos(itemPacRepo.findAll());
    }

    public ItemPacDto findItemPacById(Long idItemPac) {
        if(idItemPac == null) {
            return null;
        }
        Optional<ItemPac> ItemPac = itemPacRepo.findById(idItemPac);
        if (ItemPac.isPresent()) {
            return itemPacMapper.toDto(ItemPac.get());
        } else {
            return null;
        }
    }

    public List<ItemPacDto> getPeriodoYEstado(int periodo, String estado) {
        return itemPacMapper.toDtos(itemPacRepo.obtenerPorPeriodoYEstado(periodo, estado));
    }

    public String aprobarPorAnio(Integer anio) {
        // Validar que el año
        if (anio == null) {
            return "Error: El año es requerido";
        }
        if (anio < 2000 || anio > 2050) {
            return "Error: El año debe estar entre 2000 y 2050";
        }

        List<ItemPac> itemsPac = itemPacRepo.findByPeriodo(anio);
        if (itemsPac.isEmpty()) {
            return "No se encontraron items PAC para el año " + anio;
        }
        int aprobados = 0;
        int registrado = 0;

        List<ItemPac> itemsPacRegistrado = itemPacRepo.findByEstado("REGISTRADO");
        for (ItemPac itemPac : itemsPacRegistrado) {
            if ("REGISTRADO".equals(itemPac.getEstado())) {
                itemPac.setEstado("APROBADO");
                itemPacRepo.save(itemPac);
            }
        }
        List<ItemPac> itemsPacAprobado = itemPacRepo.findByEstado("APROBADO");
        for (ItemPac itemPac : itemsPacAprobado) {
            if(itemPac.getEstado().equals("APROBADO")) {
                aprobados++;
            }
            if (itemPac.getObjetoContratacion().isEmpty() || itemPac.getObjetoContratacion() == null) {
                itemPac.setEstado("REGISTRADO");
                itemPacRepo.save(itemPac);
                registrado++;
            }
        }

        return "Items Aprobados: " +aprobados  + " . Se cambio a REGISTRADOS: " + registrado+". En el año: "+anio;
    }
}