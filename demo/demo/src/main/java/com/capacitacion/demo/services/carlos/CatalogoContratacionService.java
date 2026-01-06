package com.capacitacion.demo.services.carlos;

import com.capacitacion.demo.dto.carlos.CargaFamiliarDto;
import com.capacitacion.demo.dto.carlos.CatalogoContratacionDto;
import com.capacitacion.demo.entity.carlos.CatalogoContratacion;
import com.capacitacion.demo.mapper.CatalogoContratacionMapper;
import com.capacitacion.demo.repository.carlos.CatalogoContratacionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CatalogoContratacionService {

    private final CatalogoContratacionRepo catalogoContratacionRepo;
    private final CatalogoContratacionMapper catalogoContratacionMapper;

    // Guardar
    public String save(CatalogoContratacionDto catalogoContratacionDto) {
        //valida codigo
        if (catalogoContratacionDto.getCodigo() != null) {
            boolean existeCodigo = catalogoContratacionRepo.existsByCodigo(catalogoContratacionDto.getCodigo());
            if (existeCodigo) {
                return "Error: Ya existe un catálogo con el código: " + catalogoContratacionDto.getCodigo();
            }
        }

        //valida que el id del padre si exista
        if (catalogoContratacionDto.getPadreId() != null) {
            Optional<CatalogoContratacion> padre = catalogoContratacionRepo.findById(catalogoContratacionDto.getPadreId());
            if (padre.isEmpty()) {
                return "Error: El catálogo padre con ID " + catalogoContratacionDto.getPadreId() + " no existe";
            }

            if (padre.get().getPadre() != null) {
                return "Error: El catálogo padre no puede ser un subcatálogo";
            }
        }
        CatalogoContratacion catalogo = catalogoContratacionMapper.toEntity(catalogoContratacionDto);
        if (catalogoContratacionDto.getPadreId() != null) {
            CatalogoContratacion padre = catalogoContratacionRepo.findById(catalogoContratacionDto.getPadreId())
                    .orElseThrow(() -> new RuntimeException("Catálogo padre no encontrado"));
            catalogo.setPadre(padre);
        }
        CatalogoContratacion guardarCatalogo = catalogoContratacionRepo.save(catalogo);
        CatalogoContratacionDto dto = catalogoContratacionMapper.toDto(guardarCatalogo);

        return "Catálogo creado exitosamente. ID: " + dto.getIdCatalogoContratacion() +
                ", Código: " + dto.getCodigo();
    }

    // Actualizar
    public String update(CatalogoContratacionDto catalogoContratacionDto) {
        //valida id antes de actualizar
        if (catalogoContratacionDto.getIdCatalogoContratacion() == null) {
            return "Error: Se requiere el ID del catálogo para actualizar";
        }
        CatalogoContratacion existeCatalogo = catalogoContratacionRepo
                .findById(catalogoContratacionDto.getIdCatalogoContratacion())
                .orElse(null);
        if (existeCatalogo == null) {
            return "Error: Catálogo no encontrado con ID: " + catalogoContratacionDto.getIdCatalogoContratacion();
        }
        if (catalogoContratacionDto.getCodigo() != null &&
                !catalogoContratacionDto.getCodigo().equals(existeCatalogo.getCodigo())) {

            boolean existeCodigo = catalogoContratacionRepo.existsByCodigo(catalogoContratacionDto.getCodigo());
            if (existeCodigo) {
                return "Error: Ya existe otro catálogo con el código: " + catalogoContratacionDto.getCodigo();
            }
            existeCatalogo.setCodigo(catalogoContratacionDto.getCodigo());
        }

        if (catalogoContratacionDto.getDescripcion() != null) {
            existeCatalogo.setDescripcion(catalogoContratacionDto.getDescripcion());
        }

        if (catalogoContratacionDto.getEstado() != null) {
            existeCatalogo.setEstado(catalogoContratacionDto.getEstado());
        }

        if (catalogoContratacionDto.getPadreId() != null) {
            if (catalogoContratacionDto.getPadreId().equals(existeCatalogo.getIdCatalogoContratacion())) {
                return "Error: Un catálogo no puede ser padre de sí mismo";
            }

            Optional<CatalogoContratacion> nuevoPadre = catalogoContratacionRepo
                    .findById(catalogoContratacionDto.getPadreId());

            if (nuevoPadre.isEmpty()) {
                return "Error: El catálogo padre con ID " + catalogoContratacionDto.getPadreId() + " no existe";
            }

            existeCatalogo.setPadre(nuevoPadre.get());
        } else if (catalogoContratacionDto.getPadreId() == null && existeCatalogo.getPadre() != null) {
            existeCatalogo.setPadre(null);
        }

        CatalogoContratacion catalogoActualizado = catalogoContratacionRepo.save(existeCatalogo);

        return "Catálogo actualizado exitosamente. ID: " + catalogoActualizado.getIdCatalogoContratacion() +
                ", Código: " + catalogoActualizado.getCodigo();
    }


    public List<CatalogoContratacionDto> cargasAll() {
        return catalogoContratacionMapper.toDtos(catalogoContratacionRepo.findAll());
    }

    public CatalogoContratacionDto findCatalogoContratacionById(Long idCatalogo) {
        if(idCatalogo == null) {
            return null;
        }
        Optional<CatalogoContratacion> CatalogoC = catalogoContratacionRepo.findById(idCatalogo);
        if (CatalogoC.isPresent()) {
            return catalogoContratacionMapper.toDto(CatalogoC.get());
        } else {
            return null;
        }
    }
}