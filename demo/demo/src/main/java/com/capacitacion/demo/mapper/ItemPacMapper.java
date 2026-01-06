package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.carlos.ItemPacDto;
import com.capacitacion.demo.entity.carlos.ItemPac;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TipoProcedimientoMapper.class})
public interface ItemPacMapper {

    @Mapping(target = "tipoProcedimientoId", source = "tipoProcedimiento.idTipoProcedimiento")
    @Mapping(target = "tipoProcedimientoDescripcion", source = "tipoProcedimiento.descripcion")
    ItemPacDto toDto(ItemPac itemPac);

    @Mapping(target = "tipoProcedimiento", ignore = true)
    ItemPac toEntity(ItemPacDto itemPacDto);

    List<ItemPacDto> toDtos(List<ItemPac> itemPacs);

    List<ItemPac> toEntities(List<ItemPacDto> itemPacDtos);
}