package com.capacitacion.demo.entity.carlos;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "catalogo_contratacion", schema = "compras_publicas")
public class CatalogoContratacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo_contratacion", nullable = false)
    private Long idCatalogoContratacion;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "padre_id",
            foreignKey = @ForeignKey(name = "catalogo_contratacion_padre_fk")
    )
    private CatalogoContratacion padre;

    @OneToMany(mappedBy = "padre", fetch = FetchType.LAZY)
    private List<CatalogoContratacion> hijos;

    @Column(name = "estado", nullable = false)
    private Boolean estado = true;
}