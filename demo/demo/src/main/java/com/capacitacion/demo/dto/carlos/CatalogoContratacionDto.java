package com.capacitacion.demo.dto.carlos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoContratacionDto {
    private Long idCatalogoContratacion;
    private String codigo;
    private String descripcion;
    private Long padreId;
    private String padreDescripcion;
    private Boolean estado;
}