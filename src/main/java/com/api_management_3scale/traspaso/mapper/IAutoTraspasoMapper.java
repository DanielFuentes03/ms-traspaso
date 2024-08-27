package com.api_management_3scale.traspaso.mapper;


import com.api_management_3scale.traspaso.dto.TraspasoDto;
import com.api_management_3scale.traspaso.model.Traspaso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAutoTraspasoMapper {

    IAutoTraspasoMapper MAPPER= Mappers.getMapper(IAutoTraspasoMapper.class);

    TraspasoDto mapToTraspasoDto(Traspaso traspaso);
    Traspaso mapToTraspaso(TraspasoDto traspasoDto);
}