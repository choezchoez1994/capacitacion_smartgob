package com.capacitacion.demo.services;

import com.capacitacion.demo.dto.PersonaDto;
import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.mapper.PersonaMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capacitacion.demo.repository.PersonaRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonaService {


    private final PersonaRepo personaRepo;
    private final PersonaMapper personaMapper;

    public PersonaDto save(PersonaDto personaDto) {
        Persona persona = personaMapper.toEntity(personaDto);
        persona = personaRepo.save(persona);
        return personaMapper.toDto(persona);
    }

    public List<PersonaDto> personasAll() {
        return personaMapper.toDtos(personaRepo.findAll());
    }

    public PersonaDto findPersonaByCedula(String cedula) {
        if (!validarCedula(cedula)) return null;
        return personaMapper.toDto(personaRepo.findPersonaByCedula(cedula));
    }

    private Boolean validarCedula(String cedula) {
        if (cedula != null && cedula.length() > 9) {
            return true;
        } else {
            return false;
        }
    }
}
