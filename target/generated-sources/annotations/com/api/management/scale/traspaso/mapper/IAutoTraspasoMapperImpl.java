package com.api.management.scale.traspaso.mapper;

import com.api.management.scale.traspaso.dto.TraspasoDto;
import com.api.management.scale.traspaso.model.Traspaso;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T18:01:50-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class IAutoTraspasoMapperImpl implements IAutoTraspasoMapper {

    @Override
    public TraspasoDto mapToTraspasoDto(Traspaso traspaso) {
        if ( traspaso == null ) {
            return null;
        }

        TraspasoDto traspasoDto = new TraspasoDto();

        traspasoDto.setId( traspaso.getId() );
        traspasoDto.setNombre( traspaso.getNombre() );
        traspasoDto.setApellidoPaterno( traspaso.getApellidoPaterno() );
        traspasoDto.setApellidoMaterno( traspaso.getApellidoMaterno() );
        traspasoDto.setNumeroCuenta( traspaso.getNumeroCuenta() );
        traspasoDto.setNss( traspaso.getNss() );
        traspasoDto.setEstatus( traspaso.getEstatus() );

        return traspasoDto;
    }

    @Override
    public Traspaso mapToTraspaso(TraspasoDto traspasoDto) {
        if ( traspasoDto == null ) {
            return null;
        }

        Traspaso traspaso = new Traspaso();

        traspaso.setId( traspasoDto.getId() );
        traspaso.setNombre( traspasoDto.getNombre() );
        traspaso.setApellidoPaterno( traspasoDto.getApellidoPaterno() );
        traspaso.setApellidoMaterno( traspasoDto.getApellidoMaterno() );
        traspaso.setNumeroCuenta( traspasoDto.getNumeroCuenta() );
        traspaso.setNss( traspasoDto.getNss() );
        traspaso.setEstatus( traspasoDto.getEstatus() );

        return traspaso;
    }
}
