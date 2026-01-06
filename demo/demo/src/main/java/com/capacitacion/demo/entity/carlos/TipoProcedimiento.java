package com.capacitacion.demo.entity.carlos;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipo_procedimiento", schema = "compras_publicas")
public class TipoProcedimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_procedimiento", nullable = false)
    private Long idTipoProcedimiento;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_tipo_compra_fk",
            foreignKey = @ForeignKey(name = "tipo_proc_compra_fk")
    )
    private CatalogoContratacion tipoCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_tipo_regimen_fk",
            foreignKey = @ForeignKey(name = "tipo_proc_regimen_fk")
    )
    private CatalogoContratacion tipoRegimen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_tipo_producto_fk",
            foreignKey = @ForeignKey(name = "tipo_proc_producto_fk")
    )
    private CatalogoContratacion tipoProducto;

    @Column(name = "estado", nullable = false)
    private Boolean estado = true;

    @OneToMany(mappedBy = "tipoProcedimiento", fetch = FetchType.LAZY)
    private List<ItemPac> itemsPac;
}