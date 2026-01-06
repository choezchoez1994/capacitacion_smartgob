package com.capacitacion.demo.services.carlos;

import com.capacitacion.demo.dto.carlos.CargaFamiliarDto;
import com.capacitacion.demo.dto.carlos.TipoProcedimientoDto;
import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.entity.carlos.CargaFamiliar;
import com.capacitacion.demo.entity.carlos.CatalogoContratacion;
import com.capacitacion.demo.entity.carlos.TipoProcedimiento;
import com.capacitacion.demo.mapper.CargaFamiliarMapper;
import com.capacitacion.demo.mapper.PersonaMapper;
import com.capacitacion.demo.mapper.TipoProcedimientoMapper;
import com.capacitacion.demo.repository.PersonaRepo;
import com.capacitacion.demo.repository.carlos.CargarFamiliarRepo;
import com.capacitacion.demo.repository.carlos.CatalogoContratacionRepo;
import com.capacitacion.demo.repository.carlos.TipoProcedimientoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TipoProcedimientoService {

    private final TipoProcedimientoRepo tipoProcedimientoRepo;
    private final CatalogoContratacionRepo catalogoContratacionRepo;
    private final TipoProcedimientoMapper tipoProcedimientoMapper;

    // Guardar tipo de procedimiento
    public String save(TipoProcedimientoDto tipoProcedimientoDto) {
        // Valida que el código no exista
        if (tipoProcedimientoDto.getCodigo() != null) {
            boolean existeCodigo = tipoProcedimientoRepo.existsByCodigo(tipoProcedimientoDto.getCodigo());
            if (existeCodigo) {
                return "Error: Ya existe un tipo de procedimiento con el código: " + tipoProcedimientoDto.getCodigo();
            }
        }
        if (tipoProcedimientoDto.getDescripcion() == null) {
                return "Error: Ingrese una descripción al procedimiento.";
        }
        if (tipoProcedimientoDto.getTipoCompraId() == null){
            return "Error: Ingrese un id de Compra.";
        }

        if (tipoProcedimientoDto.getTipoRegimenId() == null) {
            return "Error: Ingrese un id de Regimen.";

        }
        if (tipoProcedimientoDto.getTipoProductoId() == null) {
            return "Error: Ingrese un id de Producto.";
        }
        if (tipoProcedimientoDto.getTipoCompraId() != null) {
            boolean esSuCatalogo = tipoProcedimientoRepo.esHijoDePadre(tipoProcedimientoDto.getTipoCompraId(),1);
            if (!esSuCatalogo) {
                return "Error: Este subcatálogo no corresponde aquí: " + tipoProcedimientoDto.getTipoCompraId();
            }
        }
        if (tipoProcedimientoDto.getTipoRegimenId() != null) {
            boolean esSuCatalogo = tipoProcedimientoRepo.esHijoDePadre(tipoProcedimientoDto.getTipoRegimenId(),2);
            if (!esSuCatalogo) {
                return "Error: Este subcatálogo no corresponde aquí: " + tipoProcedimientoDto.getTipoRegimenId();
            }
        }
        if (tipoProcedimientoDto.getTipoProductoId() != null) {
            boolean esSuCatalogo = tipoProcedimientoRepo.esHijoDePadre(tipoProcedimientoDto.getTipoProductoId(),3);
            if (!esSuCatalogo) {
                return "Error: Este subcatálogo no corresponde aquí: " + tipoProcedimientoDto.getTipoProductoId();
            }
        }


        // Convertir a Entity
        TipoProcedimiento tipoProcedimiento = tipoProcedimientoMapper.toEntity(tipoProcedimientoDto);
        //relacionar los catalogos al tipo procedimiento
        colocarRelaciones(tipoProcedimientoDto, tipoProcedimiento);
        // Guardar
        TipoProcedimiento guardarProcedimiento = tipoProcedimientoRepo.save(tipoProcedimiento);
        TipoProcedimientoDto dto = tipoProcedimientoMapper.toDto(guardarProcedimiento);

        return "Tipo de procedimiento creado exitosamente. ID: " + dto.getIdTipoProcedimiento() +
                ", Código: " + dto.getCodigo();
    }

    // Actualizar tipo de procedimiento
    public String update(TipoProcedimientoDto tipoProcedimientoDto) {
        // Valida ID antes de actualizar
        if (tipoProcedimientoDto.getIdTipoProcedimiento() == null) {
            return "Error: Se requiere el ID del tipo de procedimiento para actualizar";
        }

        TipoProcedimiento existeProcedimiento = tipoProcedimientoRepo
                .findById(tipoProcedimientoDto.getIdTipoProcedimiento())
                .orElse(null);

        if (existeProcedimiento == null) {
            return "Error: Tipo de procedimiento no encontrado con ID: " + tipoProcedimientoDto.getIdTipoProcedimiento();
        }

        if (tipoProcedimientoDto.getCodigo() != null) {
            if (!tipoProcedimientoDto.getCodigo().equals(existeProcedimiento.getCodigo())) {
                boolean existeCodigo = tipoProcedimientoRepo.existsByCodigo(tipoProcedimientoDto.getCodigo());
                if (existeCodigo) {
                    return "Error: Ya existe otro tipo de procedimiento con el código: " + tipoProcedimientoDto.getCodigo();
                }
            }
        }

        // Validaciones de campos obligatorios
        if (tipoProcedimientoDto.getDescripcion() != null && tipoProcedimientoDto.getDescripcion().trim().isEmpty()) {
            return "Error: La descripción no puede estar vacía.";
        }

        // Validaciones de relaciones
        if (tipoProcedimientoDto.getTipoCompraId() == null) {
            return "Error: Ingrese un id de Compra.";
        }
        if (tipoProcedimientoDto.getTipoRegimenId() == null) {
            return "Error: Ingrese un id de Regimen.";
        }
        if (tipoProcedimientoDto.getTipoProductoId() == null) {
            return "Error: Ingrese un id de Producto.";
        }

        // Validaciones de catálogos
        if (tipoProcedimientoDto.getTipoCompraId() != null) {
            boolean esSuCatalogo = tipoProcedimientoRepo.esHijoDePadre(tipoProcedimientoDto.getTipoCompraId(), 1);
            if (!esSuCatalogo) {
                return "Error: Este subcatálogo no corresponde aquí: " + tipoProcedimientoDto.getTipoCompraId();
            }
        }
        if (tipoProcedimientoDto.getTipoRegimenId() != null) {
            boolean esSuCatalogo = tipoProcedimientoRepo.esHijoDePadre(tipoProcedimientoDto.getTipoRegimenId(), 2);
            if (!esSuCatalogo) {
                return "Error: Este subcatálogo no corresponde aquí: " + tipoProcedimientoDto.getTipoRegimenId();
            }
        }
        if (tipoProcedimientoDto.getTipoProductoId() != null) {
            boolean esSuCatalogo = tipoProcedimientoRepo.esHijoDePadre(tipoProcedimientoDto.getTipoProductoId(), 3);
            if (!esSuCatalogo) {
                return "Error: Este subcatálogo no corresponde aquí: " + tipoProcedimientoDto.getTipoProductoId();
            }
        }

        // Actualizar campos
        if (tipoProcedimientoDto.getCodigo() != null) {
            existeProcedimiento.setCodigo(tipoProcedimientoDto.getCodigo());
        }

        if (tipoProcedimientoDto.getDescripcion() != null) {
            existeProcedimiento.setDescripcion(tipoProcedimientoDto.getDescripcion());
        }

        if (tipoProcedimientoDto.getEstado() != null) {
            existeProcedimiento.setEstado(tipoProcedimientoDto.getEstado());
        }
        colocarRelaciones(tipoProcedimientoDto, existeProcedimiento);

        // Guardar cambios
        TipoProcedimiento procedimientoActualizado = tipoProcedimientoRepo.save(existeProcedimiento);

        return "Tipo de procedimiento actualizado exitosamente. ID: " + procedimientoActualizado.getIdTipoProcedimiento() +
                ", Código: " + procedimientoActualizado.getCodigo();
    }

    // Obtener todos
    public List<TipoProcedimientoDto> procedimientosAll() {
        return tipoProcedimientoMapper.toDtos(tipoProcedimientoRepo.findAll());
    }

    // Obtener por ID
    public TipoProcedimientoDto findTipoProcedimientoById(Long idProcedimiento) {
        if (idProcedimiento == null) {
            return null;
        }
        Optional<TipoProcedimiento> procedimiento = tipoProcedimientoRepo.findById(idProcedimiento);
        return procedimiento.map(tipoProcedimientoMapper::toDto).orElse(null);
    }
    //funcion para colocar las relaciones de los ids de los catalogos registrados en tipoProcedimiento
    private void colocarRelaciones(TipoProcedimientoDto dto, TipoProcedimiento tipoProcedimiento) {
        // Tipo de Compra
        CatalogoContratacion tipoCompra = catalogoContratacionRepo.findById(dto.getTipoCompraId())
                .orElseThrow(() -> new RuntimeException("Catálogo de Tipo de Compra no encontrado"));
        tipoProcedimiento.setTipoCompra(tipoCompra);

        //  Tipo de Régimen
        CatalogoContratacion tipoRegimen = catalogoContratacionRepo.findById(dto.getTipoRegimenId())
                .orElseThrow(() -> new RuntimeException("Catálogo de Tipo de Régimen no encontrado"));
        tipoProcedimiento.setTipoRegimen(tipoRegimen);

        // Tipo de Producto
        CatalogoContratacion tipoProducto = catalogoContratacionRepo.findById(dto.getTipoProductoId())
                .orElseThrow(() -> new RuntimeException("Catálogo de Tipo de Producto no encontrado"));
        tipoProcedimiento.setTipoProducto(tipoProducto);
    }
}