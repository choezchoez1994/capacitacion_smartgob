package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.PersonaDto;
import com.capacitacion.demo.entity.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    @Mappings({
            @Mapping(target = "cedula", source = "persona.cedula"),
            @Mapping(target = "apellido", source = "persona.apellido"),
            @Mapping(target = "nombre", source = "persona.nombre")
    })
    PersonaDto toDto(Persona persona);

    Persona toEntity(PersonaDto personaDto);

    @Mappings({
            @Mapping(target = "cedula", source = "personas.cedula"),
            @Mapping(target = "apellido", source = "personas.apellido"),
            @Mapping(target = "nombre", source = "personas.nombre")
    })
    List<PersonaDto> toDtos(List<Persona> personas);

    List<Persona> toEntities(List<PersonaDto> personaDtos);
}
