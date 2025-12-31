package com.capacitacion.demo.entity.jose;

import com.capacitacion.demo.entity.Persona;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empleado", schema = "prueba")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado", nullable = false)
    private Long idEmpleado;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;
    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;
    @Column(name = "correo_institucional", nullable = false, length = Integer.MAX_VALUE)
    private String correoInstitucional;
    @Column(name = "nombre_cargo", nullable = false, length = Integer.MAX_VALUE)
    private String nombreCargo;
    @Column(name = "nombre_area", nullable = false, length = Integer.MAX_VALUE)
    private String nombreArea;
    @Column(name = "sueldo", nullable = false, precision = 10, scale = 2)
    private BigDecimal sueldo;
    @Column(name = "estado")
    private Boolean estado;
}
