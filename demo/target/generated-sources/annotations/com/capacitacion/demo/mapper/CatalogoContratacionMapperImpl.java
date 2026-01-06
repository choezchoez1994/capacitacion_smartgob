package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.carlos.CatalogoContratacionDto;
import com.capacitacion.demo.entity.carlos.CatalogoContratacion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-05T19:15:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class CatalogoContratacionMapperImpl implements CatalogoContratacionMapper {

    @Override
    public CatalogoContratacionDto toDto(CatalogoContratacion catalogoContratacion) {
        if ( catalogoContratacion == null ) {
            return null;
        }

        CatalogoContratacionDto.CatalogoContratacionDtoBuilder catalogoContratacionDto = CatalogoContratacionDto.builder();

        catalogoContratacionDto.padreId( catalogoContratacionPadreIdCatalogoContratacion( catalogoContratacion ) );
        catalogoContratacionDto.padreDescripcion( catalogoContratacionPadreDescripcion( catalogoContratacion ) );
        catalogoContratacionDto.idCatalogoContratacion( catalogoContratacion.getIdCatalogoContratacion() );
        catalogoContratacionDto.codigo( catalogoContratacion.getCodigo() );
        catalogoContratacionDto.descripcion( catalogoContratacion.getDescripcion() );
        catalogoContratacionDto.estado( catalogoContratacion.getEstado() );

        return catalogoContratacionDto.build();
    }

    @Override
    public CatalogoContratacion toEntity(CatalogoContratacionDto catalogoContratacionDto) {
        if ( catalogoContratacionDto == null ) {
            return null;
        }

        CatalogoContratacion.CatalogoContratacionBuilder catalogoContratacion = CatalogoContratacion.builder();

        catalogoContratacion.idCatalogoContratacion( catalogoContratacionDto.getIdCatalogoContratacion() );
        catalogoContratacion.codigo( catalogoContratacionDto.getCodigo() );
        catalogoContratacion.descripcion( catalogoContratacionDto.getDescripcion() );
        catalogoContratacion.estado( catalogoContratacionDto.getEstado() );

        return catalogoContratacion.build();
    }

    @Override
    public List<CatalogoContratacionDto> toDtos(List<CatalogoContratacion> catalogoContrataciones) {
        if ( catalogoContrataciones == null ) {
            return null;
        }

        List<CatalogoContratacionDto> list = new ArrayList<CatalogoContratacionDto>( catalogoContrataciones.size() );
        for ( CatalogoContratacion catalogoContratacion : catalogoContrataciones ) {
            list.add( toDto( catalogoContratacion ) );
        }

        return list;
    }

    @Override
    public List<CatalogoContratacion> toEntities(List<CatalogoContratacionDto> catalogoContratacionDtos) {
        if ( catalogoContratacionDtos == null ) {
            return null;
        }

        List<CatalogoContratacion> list = new ArrayList<CatalogoContratacion>( catalogoContratacionDtos.size() );
        for ( CatalogoContratacionDto catalogoContratacionDto : catalogoContratacionDtos ) {
            list.add( toEntity( catalogoContratacionDto ) );
        }

        return list;
    }

    private Long catalogoContratacionPadreIdCatalogoContratacion(CatalogoContratacion catalogoContratacion) {
        if ( catalogoContratacion == null ) {
            return null;
        }
        CatalogoContratacion padre = catalogoContratacion.getPadre();
        if ( padre == null ) {
            return null;
        }
        Long idCatalogoContratacion = padre.getIdCatalogoContratacion();
        if ( idCatalogoContratacion == null ) {
            return null;
        }
        return idCatalogoContratacion;
    }

    private String catalogoContratacionPadreDescripcion(CatalogoContratacion catalogoContratacion) {
        if ( catalogoContratacion == null ) {
            return null;
        }
        CatalogoContratacion padre = catalogoContratacion.getPadre();
        if ( padre == null ) {
            return null;
        }
        String descripcion = padre.getDescripcion();
        if ( descripcion == null ) {
            return null;
        }
        return descripcion;
    }
}
