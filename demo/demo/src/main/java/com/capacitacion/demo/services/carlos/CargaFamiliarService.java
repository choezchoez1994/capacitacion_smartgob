package com.capacitacion.demo.services.carlos;

import com.capacitacion.demo.dto.PersonaDto;
import com.capacitacion.demo.dto.carlos.CargaFamiliarDto;
import com.capacitacion.demo.entity.carlos.CargaFamiliar;
import com.capacitacion.demo.entity.Persona;
import com.capacitacion.demo.mapper.CargaFamiliarMapper;
import com.capacitacion.demo.mapper.PersonaMapper;
import com.capacitacion.demo.repository.carlos.CargarFamiliarRepo;
import com.capacitacion.demo.repository.PersonaRepo;
import lombok.AllArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CargaFamiliarService {


    private  final CargarFamiliarRepo cargarFamiliarRepo;
    private  final PersonaMapper personaMapper;
    private  final CargaFamiliarMapper cargaFamiliarMapper;
    private final PersonaRepo personaRepo;

    public String save(CargaFamiliarDto cargaFamiliarDto) {
        Persona empleado = personaRepo.findPersonaByCedula(cargaFamiliarDto.getEmpleado().getCedula());
        if (empleado == null) {
            return "Empleado no encontrado con cédula: " +
                    cargaFamiliarDto.getEmpleado().getCedula();
        }
        Persona carga = personaRepo.findPersonaByCedula(cargaFamiliarDto.getCarga().getCedula());
        if (carga == null) {
            carga = personaRepo.save(personaMapper.toEntity(cargaFamiliarDto.getCarga()));
        }
        boolean existe = cargarFamiliarRepo.existsByEmpleadoAndCarga(empleado, carga);
        if (existe) {
            return "Esta carga familiar ya está registrada para este empleado";
        }
        CargaFamiliar cargaFamiliar = CargaFamiliar.builder()
                .carga(carga)
                .empleado(empleado)
                .fechaRegistro(cargaFamiliarDto.getFechaRegistro())
                .estado(cargaFamiliarDto.getEstado())
                .build();

        CargaFamiliar guardarCarga = cargarFamiliarRepo.save(cargaFamiliar);
        Integer edad = personaRepo.getEdadByCedula(carga.getCedula());
        CargaFamiliarDto dto = cargaFamiliarMapper.toDto(guardarCarga);
        dto.setEdad(edad);

        return "Carga familiar registrada exitosamente. Edad de la carga: " + edad + " años";
    }

    public String update(CargaFamiliarDto cargaFamiliarDto) {
        if (cargaFamiliarDto.getIdCarga() == null) {
            return "Error: Se requiere el ID de la carga familiar para actualizar";
        }
        CargaFamiliar existeCarga = cargarFamiliarRepo.findById(cargaFamiliarDto.getIdCarga())
                .orElse(null);
        if (existeCarga == null) {
            return "Error: Carga familiar no encontrada con ID: " + cargaFamiliarDto.getIdCarga();
        }
        if (cargaFamiliarDto.getFechaRegistro() != null) {
            existeCarga.setFechaRegistro(cargaFamiliarDto.getFechaRegistro());
        }
        if (cargaFamiliarDto.getEstado() != null) {
            existeCarga.setEstado(cargaFamiliarDto.getEstado());
        }
        CargaFamiliar cargaFamiliarActualizada = cargarFamiliarRepo.save(existeCarga);

        return "Carga familiar actualizada exitosamente. ID: " + cargaFamiliarActualizada.getIdCarga();
    }

    public String delete(Long idCarga) {
        CargaFamiliar cargaFamiliar = cargarFamiliarRepo.findById(idCarga)
                .orElse(null);

        if (cargaFamiliar == null) {
            return "Error: Carga familiar no encontrada con ID: " + idCarga;
        }
        cargarFamiliarRepo.deleteById(idCarga);
        return "Carga familiar eliminada exitosamente. ID: " + idCarga;
    }

    public List<CargaFamiliarDto> cargasAll() {
        return cargaFamiliarMapper.toDtos(cargarFamiliarRepo.findAll());
    }

    public CargaFamiliarDto findCargaFamiliarById(Long idCarga) {
        if(idCarga == null) {
            return null;
        }
        Optional<CargaFamiliar> Carga = cargarFamiliarRepo.findById(idCarga);
        if (Carga.isPresent()) {
            return cargaFamiliarMapper.toDto(Carga.get());
        } else {
            return null;
        }
    }
}