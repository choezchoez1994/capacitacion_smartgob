package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.carlos.TipoProcedimientoDto;
import com.capacitacion.demo.entity.carlos.CatalogoContratacion;
import com.capacitacion.demo.entity.carlos.TipoProcedimiento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-05T17:28:06-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class TipoProcedimientoMapperImpl implements TipoProcedimientoMapper {

    @Override
    public TipoProcedimientoDto toDto(TipoProcedimiento tipoProcedimiento) {
        if ( tipoProcedimiento == null ) {
            return null;
        }

        TipoProcedimientoDto.TipoProcedimientoDtoBuilder tipoProcedimientoDto = TipoProcedimientoDto.builder();

        tipoProcedimientoDto.tipoCompraId( tipoProcedimientoTipoCompraIdCatalogoContratacion( tipoProcedimiento ) );
        tipoProcedimientoDto.tipoCompraDescripcion( tipoProcedimientoTipoCompraDescripcion( tipoProcedimiento ) );
        tipoProcedimientoDto.tipoRegimenId( tipoProcedimientoTipoRegimenIdCatalogoContratacion( tipoProcedimiento ) );
        tipoProcedimientoDto.tipoRegimenDescripcion( tipoProcedimientoTipoRegimenDescripcion( tipoProcedimiento ) );
        tipoProcedimientoDto.tipoProductoId( tipoProcedimientoTipoProductoIdCatalogoContratacion( tipoProcedimiento ) );
        tipoProcedimientoDto.tipoProductoDescripcion( tipoProcedimientoTipoProductoDescripcion( tipoProcedimiento ) );
        tipoProcedimientoDto.idTipoProcedimiento( tipoProcedimiento.getIdTipoProcedimiento() );
        tipoProcedimientoDto.codigo( tipoProcedimiento.getCodigo() );
        tipoProcedimientoDto.descripcion( tipoProcedimiento.getDescripcion() );
        tipoProcedimientoDto.estado( tipoProcedimiento.getEstado() );

        return tipoProcedimientoDto.build();
    }

    @Override
    public TipoProcedimiento toEntity(TipoProcedimientoDto tipoProcedimientoDto) {
        if ( tipoProcedimientoDto == null ) {
            return null;
        }

        TipoProcedimiento.TipoProcedimientoBuilder tipoProcedimiento = TipoProcedimiento.builder();

        tipoProcedimiento.idTipoProcedimiento( tipoProcedimientoDto.getIdTipoProcedimiento() );
        tipoProcedimiento.codigo( tipoProcedimientoDto.getCodigo() );
        tipoProcedimiento.descripcion( tipoProcedimientoDto.getDescripcion() );
        tipoProcedimiento.estado( tipoProcedimientoDto.getEstado() );

        return tipoProcedimiento.build();
    }

    @Override
    public List<TipoProcedimientoDto> toDtos(List<TipoProcedimiento> tipoProcedimientos) {
        if ( tipoProcedimientos == null ) {
            return null;
        }

        List<TipoProcedimientoDto> list = new ArrayList<TipoProcedimientoDto>( tipoProcedimientos.size() );
        for ( TipoProcedimiento tipoProcedimiento : tipoProcedimientos ) {
            list.add( toDto( tipoProcedimiento ) );
        }

        return list;
    }

    @Override
    public List<TipoProcedimiento> toEntities(List<TipoProcedimientoDto> tipoProcedimientoDtos) {
        if ( tipoProcedimientoDtos == null ) {
            return null;
        }

        List<TipoProcedimiento> list = new ArrayList<TipoProcedimiento>( tipoProcedimientoDtos.size() );
        for ( TipoProcedimientoDto tipoProcedimientoDto : tipoProcedimientoDtos ) {
            list.add( toEntity( tipoProcedimientoDto ) );
        }

        return list;
    }

    private Long tipoProcedimientoTipoCompraIdCatalogoContratacion(TipoProcedimiento tipoProcedimiento) {
        if ( tipoProcedimiento == null ) {
            return null;
        }
        CatalogoContratacion tipoCompra = tipoProcedimiento.getTipoCompra();
        if ( tipoCompra == null ) {
            return null;
        }
        Long idCatalogoContratacion = tipoCompra.getIdCatalogoContratacion();
        if ( idCatalogoContratacion == null ) {
            return null;
        }
        return idCatalogoContratacion;
    }

    private String tipoProcedimientoTipoCompraDescripcion(TipoProcedimiento tipoProcedimiento) {
        if ( tipoProcedimiento == null ) {
            return null;
        }
        CatalogoContratacion tipoCompra = tipoProcedimiento.getTipoCompra();
        if ( tipoCompra == null ) {
            return null;
        }
        String descripcion = tipoCompra.getDescripcion();
        if ( descripcion == null ) {
            return null;
        }
        return descripcion;
    }

    private Long tipoProcedimientoTipoRegimenIdCatalogoContratacion(TipoProcedimiento tipoProcedimiento) {
        if ( tipoProcedimiento == null ) {
            return null;
        }
        CatalogoContratacion tipoRegimen = tipoProcedimiento.getTipoRegimen();
        if ( tipoRegimen == null ) {
            return null;
        }
        Long idCatalogoContratacion = tipoRegimen.getIdCatalogoContratacion();
        if ( idCatalogoContratacion == null ) {
            return null;
        }
        return idCatalogoContratacion;
    }

    private String tipoProcedimientoTipoRegimenDescripcion(TipoProcedimiento tipoProcedimiento) {
        if ( tipoProcedimiento == null ) {
            return null;
        }
        CatalogoContratacion tipoRegimen = tipoProcedimiento.getTipoRegimen();
        if ( tipoRegimen == null ) {
            return null;
        }
        String descripcion = tipoRegimen.getDescripcion();
        if ( descripcion == null ) {
            return null;
        }
        return descripcion;
    }

    private Long tipoProcedimientoTipoProductoIdCatalogoContratacion(TipoProcedimiento tipoProcedimiento) {
        if ( tipoProcedimiento == null ) {
            return null;
        }
        CatalogoContratacion tipoProducto = tipoProcedimiento.getTipoProducto();
        if ( tipoProducto == null ) {
            return null;
        }
        Long idCatalogoContratacion = tipoProducto.getIdCatalogoContratacion();
        if ( idCatalogoContratacion == null ) {
            return null;
        }
        return idCatalogoContratacion;
    }

    private String tipoProcedimientoTipoProductoDescripcion(TipoProcedimiento tipoProcedimiento) {
        if ( tipoProcedimiento == null ) {
            return null;
        }
        CatalogoContratacion tipoProducto = tipoProcedimiento.getTipoProducto();
        if ( tipoProducto == null ) {
            return null;
        }
        String descripcion = tipoProducto.getDescripcion();
        if ( descripcion == null ) {
            return null;
        }
        return descripcion;
    }
}
