package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.carlos.TipoProcedimientoDto;
import com.capacitacion.demo.entity.carlos.TipoProcedimiento;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CatalogoContratacionMapper.class})
public interface TipoProcedimientoMapper {
    @Mapping(target = "tipoCompraId", source = "tipoCompra.idCatalogoContratacion")
    @Mapping(target = "tipoCompraDescripcion", source = "tipoCompra.descripcion")
    @Mapping(target = "tipoRegimenId", source = "tipoRegimen.idCatalogoContratacion")
    @Mapping(target = "tipoRegimenDescripcion", source = "tipoRegimen.descripcion")
    @Mapping(target = "tipoProductoId", source = "tipoProducto.idCatalogoContratacion")
    @Mapping(target = "tipoProductoDescripcion", source = "tipoProducto.descripcion")
    TipoProcedimientoDto toDto(TipoProcedimiento tipoProcedimiento);

    TipoProcedimiento toEntity(TipoProcedimientoDto tipoProcedimientoDto);

    List<TipoProcedimientoDto> toDtos(List<TipoProcedimiento> tipoProcedimientos);

    List<TipoProcedimiento> toEntities(List<TipoProcedimientoDto> tipoProcedimientoDtos);

}