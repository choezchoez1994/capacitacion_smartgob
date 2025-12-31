package com.capacitacion.demo.services.jose;

import com.capacitacion.demo.dto.jose.EmpleadoDto;
import com.capacitacion.demo.dto.PersonaDto;
import com.capacitacion.demo.entity.jose.Empleado;
import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.repository.jose.EmpleadoRepo;
import com.capacitacion.demo.repository.PersonaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepo empleadoRepo;
    private final PersonaRepo personaRepo;

    @Transactional
    public Empleado save(EmpleadoDto dto) {

        Persona persona = obtenerPersona(dto);

        if (empleadoRepo.existsByCorreoInstitucional(dto.getCorreoInstitucional())) {
            throw new RuntimeException("Correo institucional ya registrado");
        }

        Empleado empleado = Empleado.builder()
                .persona(persona)
                .fechaIngreso(dto.getFechaIngreso())
                .fechaSalida(dto.getFechaSalida())
                .correoInstitucional(dto.getCorreoInstitucional())
                .nombreCargo(dto.getNombreCargo())
                .nombreArea(dto.getNombreArea())
                .sueldo(dto.getSueldo())
                .estado(true)
                .build();

        return empleadoRepo.save(empleado);
    }

    @Transactional
    public Empleado update(Long id, EmpleadoDto dto) {

        Empleado empleado = empleadoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setFechaIngreso(dto.getFechaIngreso());
        empleado.setFechaSalida(dto.getFechaSalida());
        empleado.setCorreoInstitucional(dto.getCorreoInstitucional());
        empleado.setNombreCargo(dto.getNombreCargo());
        empleado.setNombreArea(dto.getNombreArea());
        empleado.setSueldo(dto.getSueldo());

        return empleadoRepo.save(empleado);
    }

    @Transactional
    public void delete(Long id) {

        Empleado empleado = empleadoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setEstado(false);
        empleadoRepo.save(empleado);
    }

    private Persona obtenerPersona(EmpleadoDto dto) {

        // Persona existente por id
        if (dto.getIdPersona() != null) {
            return personaRepo.findById(dto.getIdPersona())
                    .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        }

        // Persona nueva o existente por cedula
        PersonaDto p = dto.getPersona();
        if (p == null || p.getCedula() == null) {
            throw new RuntimeException("Debe enviar datos de persona");
        }

        return personaRepo.findPersonaByCedula(p.getCedula()) != null
                ? personaRepo.findPersonaByCedula(p.getCedula())
                : personaRepo.save(mapToPersona(p));
    }

    private Persona mapToPersona(PersonaDto p) {
        return Persona.builder()
                .cedula(p.getCedula())
                .apellido(p.getApellido())
                .nombre(p.getNombre())
                .fechaNacimineto(p.getFechaNacimineto())
                .direccion(p.getDireccion())
                .correo(p.getCorreo())
                .telefono(p.getTelefono())
                .celular(p.getCelular())
                .build();
    }
}
