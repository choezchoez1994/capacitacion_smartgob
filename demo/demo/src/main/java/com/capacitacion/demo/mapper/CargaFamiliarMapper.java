package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.PersonaDto;
import com.capacitacion.demo.dto.carlos.CargaFamiliarDto;
import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.entity.carlos.CargaFamiliar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PersonaMapper.class})
public interface CargaFamiliarMapper {

    CargaFamiliarDto toDto(CargaFamiliar cargaFamiliar);

    CargaFamiliar toEntity(CargaFamiliarDto cargaFamiliarDto);

    List<CargaFamiliarDto> toDtos(List<CargaFamiliar> cargasFamiliares);

    List<CargaFamiliar> toEntities(List<CargaFamiliarDto> cargasFamiliasDtos);
}
