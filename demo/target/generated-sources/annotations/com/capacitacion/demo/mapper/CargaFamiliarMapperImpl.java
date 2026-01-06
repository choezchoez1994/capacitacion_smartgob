package com.capacitacion.demo.mapper;

import com.capacitacion.demo.dto.carlos.CargaFamiliarDto;
import com.capacitacion.demo.entity.carlos.CargaFamiliar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-05T19:15:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class CargaFamiliarMapperImpl implements CargaFamiliarMapper {

    @Autowired
    private PersonaMapper personaMapper;

    @Override
    public CargaFamiliarDto toDto(CargaFamiliar cargaFamiliar) {
        if ( cargaFamiliar == null ) {
            return null;
        }

        CargaFamiliarDto.CargaFamiliarDtoBuilder cargaFamiliarDto = CargaFamiliarDto.builder();

        cargaFamiliarDto.idCarga( cargaFamiliar.getIdCarga() );
        cargaFamiliarDto.empleado( personaMapper.toDto( cargaFamiliar.getEmpleado() ) );
        cargaFamiliarDto.carga( personaMapper.toDto( cargaFamiliar.getCarga() ) );
        cargaFamiliarDto.fechaRegistro( cargaFamiliar.getFechaRegistro() );
        cargaFamiliarDto.estado( cargaFamiliar.getEstado() );

        return cargaFamiliarDto.build();
    }

    @Override
    public CargaFamiliar toEntity(CargaFamiliarDto cargaFamiliarDto) {
        if ( cargaFamiliarDto == null ) {
            return null;
        }

        CargaFamiliar.CargaFamiliarBuilder cargaFamiliar = CargaFamiliar.builder();

        cargaFamiliar.idCarga( cargaFamiliarDto.getIdCarga() );
        cargaFamiliar.empleado( personaMapper.toEntity( cargaFamiliarDto.getEmpleado() ) );
        cargaFamiliar.carga( personaMapper.toEntity( cargaFamiliarDto.getCarga() ) );
        cargaFamiliar.fechaRegistro( cargaFamiliarDto.getFechaRegistro() );
        cargaFamiliar.estado( cargaFamiliarDto.getEstado() );

        return cargaFamiliar.build();
    }

    @Override
    public List<CargaFamiliarDto> toDtos(List<CargaFamiliar> cargasFamiliares) {
        if ( cargasFamiliares == null ) {
            return null;
        }

        List<CargaFamiliarDto> list = new ArrayList<CargaFamiliarDto>( cargasFamiliares.size() );
        for ( CargaFamiliar cargaFamiliar : cargasFamiliares ) {
            list.add( toDto( cargaFamiliar ) );
        }

        return list;
    }

    @Override
    public List<CargaFamiliar> toEntities(List<CargaFamiliarDto> cargasFamiliasDtos) {
        if ( cargasFamiliasDtos == null ) {
            return null;
        }

        List<CargaFamiliar> list = new ArrayList<CargaFamiliar>( cargasFamiliasDtos.size() );
        for ( CargaFamiliarDto cargaFamiliarDto : cargasFamiliasDtos ) {
            list.add( toEntity( cargaFamiliarDto ) );
        }

        return list;
    }
}
