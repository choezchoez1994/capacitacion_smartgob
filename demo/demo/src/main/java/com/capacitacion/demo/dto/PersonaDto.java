package com.capacitacion.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {

    private Long id;
    private String cedula;
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimineto;
    private String direccion;
    private String correo;
    private String telefono;
    private String celular;

}
