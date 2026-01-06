package com.capacitacion.demo.entity.carlos;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_pac", schema = "compras_publicas")
public class ItemPac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_pac", nullable = false)
    private Long idItemPac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "tipo_procedimiento_fk",
            nullable = false,
            foreignKey = @ForeignKey(name = "item_pac_tipo_proc_fk")
    )
    private TipoProcedimiento tipoProcedimiento;

    @Column(name = "objeto_contratacion", nullable = false, columnDefinition = "TEXT")
    private String objetoContratacion;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "periodo", nullable = false)
    private Integer periodo;

    @Column(name = "valor_unitario", nullable = false, precision = 15, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad = 1;

    @Column(name = "valor_total", nullable = false, precision = 15, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "cuatrimestre")
    private Integer cuatrimestre;
}