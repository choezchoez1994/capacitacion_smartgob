package com.capacitacion.demo.dto.carlos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoProcedimientoDto {
    private Long idTipoProcedimiento;
    private String codigo;
    private String descripcion;
    private Long tipoCompraId;
    private String tipoCompraDescripcion;
    private Long tipoRegimenId;
    private String tipoRegimenDescripcion;
    private Long tipoProductoId;
    private String tipoProductoDescripcion;
    private Boolean estado;
}