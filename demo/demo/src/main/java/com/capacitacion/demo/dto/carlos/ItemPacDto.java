package com.capacitacion.demo.dto.carlos;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemPacDto {
    private Long idItemPac;
    private Long tipoProcedimientoId;
    private String tipoProcedimientoDescripcion;
    private String objetoContratacion; //Descripcion
    private String estado;
    private Integer periodo;
    private BigDecimal valorUnitario;
    private Integer cantidad;
    private BigDecimal valorTotal;
    private Integer cuatrimestre;//1 2 3
}