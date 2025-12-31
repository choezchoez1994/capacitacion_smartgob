package com.capacitacion.demo.dto.jose;

import com.capacitacion.demo.dto.PersonaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {

    // Persona (existente o nueva)
    private Long idPersona;
    private PersonaDto persona;

    // Empleado
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private String correoInstitucional;
    private String nombreCargo;
    private String nombreArea;
    private BigDecimal sueldo;
}
