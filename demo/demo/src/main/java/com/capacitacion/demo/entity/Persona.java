package com.capacitacion.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona", schema = "prueba")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "apellido", nullable = false, length = Integer.MAX_VALUE)
    private String apellido;
    @Column(name = "nombre", nullable = false, length = Integer.MAX_VALUE)
    private String nombre;
    @Column(name = "fecha_nacimineto", nullable = false)
    private LocalDate fechaNacimineto;
    @Column(name = "direccion", length = Integer.MAX_VALUE)
    private String direccion;
    @Column(name = "correo", length = Integer.MAX_VALUE)
    private String correo;
    @Column(name = "telefono", length = Integer.MAX_VALUE)
    private String telefono;
    @Column(name = "celular", length = Integer.MAX_VALUE)
    private String celular;
    @Column(name = "cedula", nullable = false, length = Integer.MAX_VALUE)
    private String cedula;

}