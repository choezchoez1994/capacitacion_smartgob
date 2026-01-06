package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.carlos.ItemPacDto;
import com.capacitacion.demo.entity.carlos.ItemPac;
import com.capacitacion.demo.entity.carlos.TipoProcedimiento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-05T18:37:27-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class ItemPacMapperImpl implements ItemPacMapper {

    @Override
    public ItemPacDto toDto(ItemPac itemPac) {
        if ( itemPac == null ) {
            return null;
        }

        ItemPacDto.ItemPacDtoBuilder itemPacDto = ItemPacDto.builder();

        itemPacDto.tipoProcedimientoId( itemPacTipoProcedimientoIdTipoProcedimiento( itemPac ) );
        itemPacDto.tipoProcedimientoDescripcion( itemPacTipoProcedimientoDescripcion( itemPac ) );
        itemPacDto.idItemPac( itemPac.getIdItemPac() );
        itemPacDto.objetoContratacion( itemPac.getObjetoContratacion() );
        itemPacDto.estado( itemPac.getEstado() );
        itemPacDto.periodo( itemPac.getPeriodo() );
        itemPacDto.valorUnitario( itemPac.getValorUnitario() );
        itemPacDto.cantidad( itemPac.getCantidad() );
        itemPacDto.valorTotal( itemPac.getValorTotal() );
        itemPacDto.cuatrimestre( itemPac.getCuatrimestre() );

        return itemPacDto.build();
    }

    @Override
    public ItemPac toEntity(ItemPacDto itemPacDto) {
        if ( itemPacDto == null ) {
            return null;
        }

        ItemPac.ItemPacBuilder itemPac = ItemPac.builder();

        itemPac.idItemPac( itemPacDto.getIdItemPac() );
        itemPac.objetoContratacion( itemPacDto.getObjetoContratacion() );
        itemPac.estado( itemPacDto.getEstado() );
        itemPac.periodo( itemPacDto.getPeriodo() );
        itemPac.valorUnitario( itemPacDto.getValorUnitario() );
        itemPac.cantidad( itemPacDto.getCantidad() );
        itemPac.valorTotal( itemPacDto.getValorTotal() );
        itemPac.cuatrimestre( itemPacDto.getCuatrimestre() );

        return itemPac.build();
    }

    @Override
    public List<ItemPacDto> toDtos(List<ItemPac> itemPacs) {
        if ( itemPacs == null ) {
            return null;
        }

        List<ItemPacDto> list = new ArrayList<ItemPacDto>( itemPacs.size() );
        for ( ItemPac itemPac : itemPacs ) {
            list.add( toDto( itemPac ) );
        }

        return list;
    }

    @Override
    public List<ItemPac> toEntities(List<ItemPacDto> itemPacDtos) {
        if ( itemPacDtos == null ) {
            return null;
        }

        List<ItemPac> list = new ArrayList<ItemPac>( itemPacDtos.size() );
        for ( ItemPacDto itemPacDto : itemPacDtos ) {
            list.add( toEntity( itemPacDto ) );
        }

        return list;
    }

    private Long itemPacTipoProcedimientoIdTipoProcedimiento(ItemPac itemPac) {
        if ( itemPac == null ) {
            return null;
        }
        TipoProcedimiento tipoProcedimiento = itemPac.getTipoProcedimiento();
        if ( tipoProcedimiento == null ) {
            return null;
        }
        Long idTipoProcedimiento = tipoProcedimiento.getIdTipoProcedimiento();
        if ( idTipoProcedimiento == null ) {
            return null;
        }
        return idTipoProcedimiento;
    }

    private String itemPacTipoProcedimientoDescripcion(ItemPac itemPac) {
        if ( itemPac == null ) {
            return null;
        }
        TipoProcedimiento tipoProcedimiento = itemPac.getTipoProcedimiento();
        if ( tipoProcedimiento == null ) {
            return null;
        }
        String descripcion = tipoProcedimiento.getDescripcion();
        if ( descripcion == null ) {
            return null;
        }
        return descripcion;
    }
}
