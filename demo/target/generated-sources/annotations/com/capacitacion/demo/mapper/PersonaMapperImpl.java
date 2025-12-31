package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.PersonaDto;
import com.capacitacion.demo.entity.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-31T09:18:50-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public PersonaDto toDto(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaDto.PersonaDtoBuilder personaDto = PersonaDto.builder();

        personaDto.cedula( persona.getCedula() );
        personaDto.apellido( persona.getApellido() );
        personaDto.nombre( persona.getNombre() );
        personaDto.id( persona.getId() );
        personaDto.fechaNacimineto( persona.getFechaNacimineto() );
        personaDto.direccion( persona.getDireccion() );
        personaDto.correo( persona.getCorreo() );
        personaDto.telefono( persona.getTelefono() );
        personaDto.celular( persona.getCelular() );

        return personaDto.build();
    }

    @Override
    public Persona toEntity(PersonaDto personaDto) {
        if ( personaDto == null ) {
            return null;
        }

        Persona.PersonaBuilder persona = Persona.builder();

        persona.id( personaDto.getId() );
        persona.apellido( personaDto.getApellido() );
        persona.nombre( personaDto.getNombre() );
        persona.fechaNacimineto( personaDto.getFechaNacimineto() );
        persona.direccion( personaDto.getDireccion() );
        persona.correo( personaDto.getCorreo() );
        persona.telefono( personaDto.getTelefono() );
        persona.celular( personaDto.getCelular() );
        persona.cedula( personaDto.getCedula() );

        return persona.build();
    }

    @Override
    public List<PersonaDto> toDtos(List<Persona> personas) {
        if ( personas == null ) {
            return null;
        }

        List<PersonaDto> list = new ArrayList<PersonaDto>( personas.size() );
        for ( Persona persona : personas ) {
            list.add( toDto( persona ) );
        }

        return list;
    }

    @Override
    public List<Persona> toEntities(List<PersonaDto> personaDtos) {
        if ( personaDtos == null ) {
            return null;
        }

        List<Persona> list = new ArrayList<Persona>( personaDtos.size() );
        for ( PersonaDto personaDto : personaDtos ) {
            list.add( toEntity( personaDto ) );
        }

        return list;
    }
}
