package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.carlos.CatalogoContratacionDto;
import com.capacitacion.demo.entity.carlos.CatalogoContratacion;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogoContratacionMapper {
    @Mappings({
            @Mapping(target = "padreId", source = "padre.idCatalogoContratacion"),
            @Mapping(target = "padreDescripcion", source = "padre.descripcion")
    })
    CatalogoContratacionDto toDto(CatalogoContratacion catalogoContratacion);

    @Mappings({
            @Mapping(target = "padre", ignore = true),
            @Mapping(target = "hijos", ignore = true)
    })
    CatalogoContratacion toEntity(CatalogoContratacionDto catalogoContratacionDto);

    List<CatalogoContratacionDto> toDtos(List<CatalogoContratacion> catalogoContrataciones);

    List<CatalogoContratacion> toEntities(List<CatalogoContratacionDto> catalogoContratacionDtos);
}