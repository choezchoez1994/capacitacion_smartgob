package com.capacitacion.demo.entity.carlos;

import com.capacitacion.demo.entity.Persona;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cargas_familiares", schema = "\"DatosAdicionales\"")
public class CargaFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carga_pk", nullable = false)
    private Long idCarga;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_persona_empleado_fk",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_persona_empleado")
    )
    private Persona empleado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_persona_carga_fk",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_persona_carga")
    )
    private Persona carga;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro = LocalDate.now();
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;
}