package com.capacitacion.demo.dto.carlos;
import com.capacitacion.demo.dto.PersonaDto;
import com.capacitacion.demo.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargaFamiliarDto {
    private Long idCarga;
    private PersonaDto empleado;
    private PersonaDto carga;
    private LocalDate fechaRegistro;
    private String estado;

    private Integer edad;
    private String mensaje;
}