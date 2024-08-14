package com.api.management.scale.traspaso.mapper;

import com.api.management.scale.traspaso.dto.TraspasoDto;
import com.api.management.scale.traspaso.model.Traspaso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAutoTraspasoMapper {

    IAutoTraspasoMapper MAPPER= Mappers.getMapper(IAutoTraspasoMapper.class);

    TraspasoDto mapToTraspasoDto(Traspaso traspaso);
    Traspaso mapToTraspaso(TraspasoDto traspasoDto);
}
